package br.com.dashmottu.controllers.patio;

import br.com.dashmottu.model.dto.PatioDTO;
import br.com.dashmottu.model.entities.Patio;
import br.com.dashmottu.service.PatioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller("webPatioController")
@RequestMapping("/patios")
public class PatioController {

    @Autowired
    public PatioService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("patios", service.listarTodos());
        return "patios/listar";
    }

    @GetMapping("/nova")
    public String nova(Model model) {
        model.addAttribute("patio", new PatioDTO());
        return "patios/formulario";
    }

    @GetMapping("/motos")
    public String motosDoPatio(@RequestParam("idPatio") Long idPatio, Model model) {
        Patio patio = service.obterPorId(idPatio);
        model.addAttribute("motos", patio.getMotos());
        model.addAttribute("idPatio", idPatio);
        model.addAttribute("patioContext", true);
        model.addAttribute("titulo", "Motos registradas no Pátio " + idPatio);
        return "motos/listar";
    }

    @GetMapping("editarEndereco/{id}")
    public String editar(@PathVariable("id") Long id, Model model) throws Exception {
        model.addAttribute("patio", service.obterPorId(id));
        return "patios/editEndereco";
    }

    @GetMapping("delete/{id}")
    public String deletar(@PathVariable("id") Long id, Model model){
        service.deletar(id);
        return "redirect:/patios";
    }

    @GetMapping("/adicionar/moto")
    public String salvarMotoNoPatio(@RequestParam("idPatio") Long idPatio, @RequestParam("idMoto") Long idMoto) {
        service.salvarMoto(idPatio, idMoto);
        return "redirect:/patios/motos?idPatio="+idPatio;
    }

    @PostMapping()
    public String salvar(@Valid @ModelAttribute("patio") PatioDTO entidade, BindingResult result) {
        entidade.setImagemPlantaUrl("https://http.cat/images/800.jpg");
        if (result.hasErrors())
            return "patios/formulario";
        service.salvar(entidade);
        return "redirect:/patios";
    }

    @PostMapping("atualizar/{id}")
    public String atualizar(@PathVariable("id") Long id, @Valid @ModelAttribute("patio") PatioDTO entidade, BindingResult result){
        if (result.hasErrors())
            return "patios/formularioEdit";
        service.editar(id, entidade);
        return "redirect:/patios";
    }
}
