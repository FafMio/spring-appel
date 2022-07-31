package fr.humanbooster.sroux.appels.controller;

import fr.humanbooster.sroux.appels.business.Appel;
import fr.humanbooster.sroux.appels.business.Employe;

import fr.humanbooster.sroux.appels.service.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class MainController {

    private SupportPublicitaireService supportPublicitaireService;
    private TypeAppelantService typeAppelantService;
    private EmployeService employeService;
    private StatutService statutService;
    private AppelService appelService;
    private HttpSession session;

    @GetMapping({"/", "/index"})
    public ModelAndView indexGet(@ModelAttribute Employe employe) {
        return new ModelAndView("redirect:connexion");
    }

    // AUTHENTICATION
    @GetMapping({"inscription", "register"})
    public ModelAndView inscriptionGet(@ModelAttribute Employe employe) {
        ModelAndView mav = new ModelAndView("auth/register");
        return mav;
    }

    @PostMapping({"inscription", "register"})
    public ModelAndView inscriptionPost(
            @Valid @ModelAttribute Employe employe, BindingResult result
    ) {
        if (result.hasErrors()) {
            return inscriptionGet(employe);
        }
        else  {
            employeService.enregistrerEmploye(employe);
            session.setAttribute("employe", employe);
            ModelAndView mav = new ModelAndView("redirect:index");
            mav.addObject("notif", "Employe ajouté");
            return mav;
        }
    }

    @GetMapping({"connexion", "login"})
    public ModelAndView connexionGet() {
        ModelAndView mav = new ModelAndView("auth/login");
        return mav;
    }

    @PostMapping({"connexion", "login"})
    public ModelAndView connexionPost(
        @RequestParam("email") String email,
        @RequestParam("password") String password)
    {
        Employe employe = employeService.recupererEmploye(email, password);
        if (employe == null) {
            ModelAndView mav = new ModelAndView("redirect:login");
            mav.addObject("notification", "Mot de passe et/ou email incorrect");
            return mav;
        } else {
            session.setAttribute("employe", employe);
            ModelAndView mav = new ModelAndView("redirect:appels");
            return mav;
        }
    }

    @RequestMapping({"/deconnexion", "/logout"})
    public ModelAndView logout () {
        if(session != null) session.invalidate();
        return new ModelAndView("redirect:connexion");
    }

    @GetMapping("/appels")
    public ModelAndView appelsGet (@PageableDefault(size = 5) Pageable pageable) {
        ModelAndView mav = new ModelAndView("call/call-list");
        mav.addObject("appels", appelService.recupererAppels(pageable));
        return mav;
    }

    @GetMapping("appels/ajouter")
    public ModelAndView appelsAddGet (@ModelAttribute Appel appel) {
        ModelAndView mav = new ModelAndView("call/call-create");
        mav.addObject("supportsPublicitaire", supportPublicitaireService.recupererSupportPublicitaire());
        mav.addObject("typesAppelant", typeAppelantService.recupererTypeAppelant());
        mav.addObject("allEmployesConcernes", employeService.recupererEmployes());
        mav.addObject("allHistoriqueStatuts", statutService.recupererStatus());
        return mav;
    }

    // TODO faire le post (manque de temps)
    @PostMapping("/appels/ajouter")
    public ModelAndView appelsAddPost (
            @Valid @ModelAttribute Appel appel,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            ModelAndView mav = appelsAddGet(appel);
            return mav;
        } else {
            appelService.enregistrerAppel(appel);
            ModelAndView mav = new ModelAndView("redirect:");
            return mav;
        }
    }
}
