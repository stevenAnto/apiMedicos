package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.usuarios.DdatosAutenticacionUsario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionControler {
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping
    public ResponseEntity autenticationUser(@RequestBody @Valid DdatosAutenticacionUsario ddatosAutenticacionUsario){//aqui es la autenticacion
        Authentication token = new UsernamePasswordAuthenticationToken(
                ddatosAutenticacionUsario.login(),
                ddatosAutenticacionUsario.clave()
        );
        authenticationManager.authenticate(token);
        return  ResponseEntity.ok().build();
    }
}
