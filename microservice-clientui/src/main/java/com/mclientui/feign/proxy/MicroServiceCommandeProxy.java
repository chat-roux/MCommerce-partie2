package com.mclientui.feign.proxy;

import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mclientui.feign.bean.CommandeBean;

/**
 * <b>PROXY PERMETTANT D'ACCEDER AU COMPOSANT CI-DESSOUS :</b><br/>
 *    ->LE MICRO-SERVICE 'MCommande'<br/>
 *    <br/>
 * @author 1603599
 *
 */
@RibbonClient(name = "microservice-commande")
@FeignClient(name = "zuul-server")
public interface MicroServiceCommandeProxy {

	@RequestMapping(value = "/microservice-commande/commande/{id}", method=RequestMethod.GET)
	public abstract Optional<CommandeBean> rechercherParId(@PathVariable(name="id") Long pId);

	@RequestMapping(value="/microservice-commande/commande", method=RequestMethod.POST)
	public abstract ResponseEntity<CommandeBean> creer(@RequestBody CommandeBean pCommandeBean);

	@RequestMapping(value="/microservice-commande/commande/completer/{produitPrix}", method=RequestMethod.PATCH)
	public abstract ResponseEntity<CommandeBean> completer(@PathVariable(name="produitPrix") Double pProduitPrix
															, @RequestBody CommandeBean pCommandeBean);
	
	@RequestMapping(value="/microservice-commande/commande/finaliser", method=RequestMethod.PATCH)
	public abstract ResponseEntity<CommandeBean> finaliser(@RequestBody CommandeBean pCommandeBean);
}
