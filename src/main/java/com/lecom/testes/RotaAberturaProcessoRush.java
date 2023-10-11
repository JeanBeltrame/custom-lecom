package com.lecom.testes;

import java.util.HashMap;
import java.util.Map;

import com.lecom.workflow.cadastros.rotas.AbreProcesso;
import com.lecom.workflow.cadastros.rotas.LoginAutenticacao;
import com.lecom.workflow.cadastros.rotas.exception.AbreProcessoException;
import com.lecom.workflow.cadastros.rotas.exception.LoginAuthenticationException;
import com.lecom.workflow.cadastros.rotas.util.DadosLogin;
import com.lecom.workflow.cadastros.rotas.util.DadosProcesso;
import com.lecom.workflow.cadastros.rotas.util.DadosProcessoAbertura;

public class RotaAberturaProcessoRush {

	public static void main(String[] args) {
        try {
        
            String urlSSo = "https://rush.dev.local/sso/";
            String loginUsuario = "adm";
            String senhaUsuario  = "adm";
            boolean manterLogado = false;
            DadosLogin dadosLogin = new DadosLogin(loginUsuario,senhaUsuario, manterLogado);
            LoginAutenticacao loginAutentica = new LoginAutenticacao(urlSSo, dadosLogin);
            
            String token = loginAutentica.getToken();

            System.out.println("token = "+token);
            
            String urlBPm = "https://rush.dev.local/bpm/";
            String codigoFormulario="26";
            String codigoVersao = "1";
            String modoTeste = "false";
            String codigoUsuarioIniciador="1";
            Map<String, String> valores = new HashMap<>();
            
            
            for (int i = 1; i <= 4; i++) {
                String repeticao = i < 10 ? "0" + String.valueOf(i) : String.valueOf(i);


                    valores.put("TESTE1_" + repeticao,"Bruno");
                            
                    valores.put("TESTE2_" + repeticao,"Sim");
            
                        
                            
                }
            
            valores.put("TESTE4","Teste LINHA TEXTO");
            valores.put("TESTE5","Teste LISTA");
    
            
            
            DadosProcesso dadosProcesso = new DadosProcesso("");
            dadosProcesso.geraPadroes(valores);
            
            
        AbreProcesso abreProcesso = new AbreProcesso(urlBPm, token, codigoFormulario,codigoVersao,modoTeste,codigoUsuarioIniciador,dadosProcesso);
        DadosProcessoAbertura aberturaUtil = abreProcesso.getAbreProcesso();
        
        System.out.println(aberturaUtil.getCurrentCycle());
        String retornoWS = aberturaUtil.getProcessInstanceId();
        
        
        System.out.println(retornoWS);
        } catch (LoginAuthenticationException e) {
            e.printStackTrace();
            
        }catch (AbreProcessoException e) {
            e.printStackTrace();
        }
    }

}
