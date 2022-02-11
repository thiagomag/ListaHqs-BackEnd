package br.com.thiago.listahqsbackend.controller;

import br.com.thiago.listahqsbackend.configuration.security.TokenService;
import br.com.thiago.listahqsbackend.dto.TokenDto;
import br.com.thiago.listahqsbackend.dto.form.LoginForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AutenticacaoController {

    private final AuthenticationManager authManager;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody LoginForm form) {
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();

        try {
            Authentication authenticate = authManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authenticate);

            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }

    }
}