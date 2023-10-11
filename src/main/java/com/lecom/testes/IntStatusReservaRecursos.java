package com.lecom.testes;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lecom.workflow.robo.RBOpenWebServices;
import com.lecom.workflow.robo.face.GenericWSVO;
import com.lecom.workflow.vo.IntegracaoVO;

import br.com.lecom.atos.servicos.annotation.Execution;
import br.com.lecom.atos.servicos.annotation.IntegrationModule;
import br.com.lecom.atos.servicos.annotation.Version;



@IntegrationModule("IntStatusReservaRecursos")
@Version({1,0,0})
public class IntStatusReservaRecursos {
    
    private static final Logger logger = LoggerFactory.getLogger(IntStatusReservaRecursos.class);
    @Execution
    public String executa (IntegracaoVO integracaoVO) {
        logger.info(" ------------------- teste ------------------- ");
	    return "0|sucesso";
	}
}