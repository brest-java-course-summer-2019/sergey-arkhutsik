package com.epam.brest.summer.courses2019.web_app;

import com.epam.brest.summer.courses2019.model.Client;
import com.epam.brest.summer.courses2019.service.ClientService;
import com.epam.brest.summer.courses2019.web_app.validators.ClientValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Client controller.
 */
@Controller
public class ClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @Autowired
    ClientValidator clientValidator;

    /**
     * Goto clients list page.
     *
     * @param model model
     * @return view name
     */
    @GetMapping(value = "/clients")
    public final String clients(Model model)
            throws Exception {
        LOGGER.debug("findAll({})", model);
        model.addAttribute("clients", clientService.findAllWithDevices());
        return "clients";
    }

    /**
     * Goto edit client page.
     *
     * @return view name
     */
    @GetMapping(value = "/client/{id}")
    public final String gotoEditClientPage(@PathVariable Integer id, Model model) throws Exception {

        LOGGER.debug("gotoEditClientPage({},{})", id, model);
        model.addAttribute("client", clientService.findById(id));
        model.addAttribute("isNew", false);
        return "client";
    }

    /**
     * Update client into persistence storage.
     *
     * @return view name
     */
    @PostMapping(value = "/client/{id}")
    public String updateClient(@Valid Client client,
                                   BindingResult result,
                                    Model model) throws Exception {
        LOGGER.debug("updateClient({}, {})", client, result);
        if (result.hasErrors()) {
            model.addAttribute("client", client);
            model.addAttribute("isNew", false);
            return "client";
        } else {
            this.clientService.update(client);
            return "redirect:/clients";
        }
    }

    /**
     * Goto add client page.
     *
     * @return view name
     */
    @GetMapping(value = "/client")
    public final String gotoAddClientPage(Model model) throws Exception {
        LOGGER.debug("gotoAddClientPage({})", model);

        Client client = new Client();
        model.addAttribute("isNew", true);
        model.addAttribute("client", client);
        return "client";
    }

    /**
     * Persist new client into persistence storage.
     *
     * @param client new client with filled data.
     * @param result     binding result.
     * @return view name
     */
    @PostMapping(value = "/client")
    public String addClient(@Valid Client client,
                                BindingResult result,
                                Model model) throws Exception  {
        LOGGER.debug("addClient({}, {})", client, result);
        clientValidator.validate(client, result);
        if (result.hasErrors()) {
            model.addAttribute("client", client);
            model.addAttribute("isNew", true);
            return "client";
        } else {
            this.clientService.add(client);
            return "redirect:/clients";
        }
    }

    /**
     * Delete client.
     *
     * @return view name
     */
    @GetMapping(value = "/client/{id}/delete")
    public final String deleteClientById(@PathVariable Integer id, Model model)
            throws Exception {
        LOGGER.debug("delete({},{})", id, model);
        clientService.delete(id);
        return "redirect:/clients";
    }
}