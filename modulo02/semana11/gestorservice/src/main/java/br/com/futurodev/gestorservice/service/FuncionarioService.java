package br.com.futurodev.gestorservice.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.futurodev.gestorservice.exceptions.ConflitoException;
import br.com.futurodev.gestorservice.exceptions.NaoEncontradoException;
import br.com.futurodev.gestorservice.model.FuncionarioEntity;
import br.com.futurodev.gestorservice.model.PapelEnum;
import br.com.futurodev.gestorservice.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public FuncionarioEntity inserir(FuncionarioEntity funcionarioEntity) {
        validarExisteFuncionarioComEmail(funcionarioEntity.getEmail());
        funcionarioEntity.setPapel(PapelEnum.FUNCIONARIO);
        funcionarioEntity.setDataContratacao(LocalDate.now());   
        funcionarioEntity.setSenha(passwordEncoder.encode("123456"));
        return this.funcionarioRepository.save(funcionarioEntity);     
    }

    public FuncionarioEntity buscarPorId(Integer id) {
        return this.funcionarioRepository.findById(id)
            .orElseThrow(() -> new NaoEncontradoException("Funcionario nao encontrado"));
    }

    private void validarExisteFuncionarioComEmail(String email) {
        if (this.funcionarioRepository.existsByEmail(email)) {
            throw new ConflitoException("Ja existe um funcionario com o email informado.");
        }
    }

}
