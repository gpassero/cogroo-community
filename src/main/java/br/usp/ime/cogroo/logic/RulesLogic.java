package br.usp.ime.cogroo.logic;

import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.usp.ime.cogroo.dao.CogrooFacade;
import br.usp.pcs.lta.cogroo.tools.checker.rules.model.Rule;

@Component
@ApplicationScoped
public class RulesLogic {
	
	private SortedMap<Long, Rule> ruleMap;
	private CogrooFacade cogrooFacade;
	
	public RulesLogic(CogrooFacade cogrooFacade) {
		this.cogrooFacade = cogrooFacade;
	}
	
	private void init() {
		if(ruleMap == null) {
			List<Rule> rules = cogrooFacade.getRules();
			ruleMap = new TreeMap<Long, Rule>();
			for (Rule rule : rules) {
				ruleMap.put(new Long(rule.getId()), rule);
			}
		}
	}

	public Collection<Rule> getRuleList() {
		init();
		return ruleMap.values();
	}
	
	public Rule getRule(Long id) {
		init();
		return ruleMap.get(id);
	}
	
	public String getNextRuleID(long currentRuleID) {
		long max = ruleMap.lastKey().longValue();
		for(long i = currentRuleID + 1; i <= max; i++) {
			if(ruleMap.get(Long.valueOf(i)) != null) {
				return Long.toString(i);
			}
		}
		return null;
	}
	
	public String getPreviousRuleID(long currentRuleID) {
		long min = ruleMap.firstKey().longValue();
		for(long i = currentRuleID - 1; i >= min; i--) {
			if(ruleMap.get(Long.valueOf(i)) != null) {
				return Long.toString(i);
			}
		}
		return null;
	}

}
