package com.algaworks.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.socialbooks.domain.DetalhesErro;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;

/**
 * @author Rodrigo Melo Esta classe implementa o padrão Handler. É um
 *         interceptador que captura e trata excessões lançadas pela aplicação
 *         nos resources.
 */
@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleLivroNãoEncontradoException(LivroNaoEncontradoException e,
			HttpServletRequest request) {
		
		// Carrega as informações que serão exibidas na mensagem de erro do console.
		DetalhesErro erro = new DetalhesErro();
		erro.setSatus(404l);
		erro.setTitulo("O livro não pôde ser encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.socialbook.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}