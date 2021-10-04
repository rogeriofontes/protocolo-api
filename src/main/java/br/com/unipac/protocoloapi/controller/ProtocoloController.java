package br.com.unipac.protocoloapi.controller;

import br.com.unipac.protocoloapi.model.domain.Protocolo;
import br.com.unipac.protocoloapi.model.repositorio.ProtocoloRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/protocolos/")
public class ProtocoloController {

    @Autowired
    private ProtocoloRepositorio protocoloRepositorio;

    @GetMapping("lista")
    public String lista(Model model) {
        model.addAttribute("listaDeProtocolos", protocoloRepositorio.findAll());
        return "index";
    }

    @GetMapping("adicionar")
    public String addProtocoloes(Protocolo protocolo) {
        return "add-protocolo";
    }

    @PostMapping("add")
    public String addProtocolo(Protocolo protocolo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-protocolo";
        }

        protocoloRepositorio.save(protocolo);

        return "redirect:lista";
    }
}
