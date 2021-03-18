package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Agent;
import com.bagile.gmo.entities.GmoAgent;

import java.util.*;

public class AgentMapper {
    public AgentMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoAgentId");
        map.put("code", "gmoAgentCode");
        map.put("cin", "gmoAgentCin");
        map.put("birthDate", "gmoAgentBirthDate");
        map.put("lastMedicalVisit", "gmoAgentLastMedicalVisit");
        map.put("working", "gmoWorking");
        map.put("name", "gmoAgentName");
        map.put("tele1", "gmoAgentTele1");
        map.put("responsability", "gmoResponsability");

        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static GmoAgent toEntity(Agent agent, boolean lazy) {
        if (null == agent) {
            return null;
        }
        GmoAgent gmoAgent = new GmoAgent();
        gmoAgent.setGmoAgentId(agent.getId());
        gmoAgent.setGmoAgentCin(agent.getCin());
        gmoAgent.setGmoAgentCode(agent.getCode() != null ? agent.getCode().toUpperCase() : null);
      // gmoAgent.setGmoAgentCommission(agent.getCommissions());
        gmoAgent.setGmoAgentLastMedicalVisit(agent.getLastMedicalVisit());
        gmoAgent.setGmoAgentBirthDate (agent.getBirthDate());
        gmoAgent.setGmoWorking(agent.isWorking());
       // gmoAgent.setGmoBadgeTypeAgents(agent.getBadgeTypeAgents());
        gmoAgent.setGmoAgentName(agent.getName());
        gmoAgent.setGmoAgentTele1(agent.getTele1());



        if (!lazy) {
            gmoAgent.setOwnOwner(OwnerMapper.toEntity(agent.getOwner(), false));
            gmoAgent.setGmoResponsability(ResponsabilityMapper.toEntity(agent.getResponsability(), false));



        }
        return gmoAgent;

    }



    public static Agent toDto(GmoAgent gmoAgent, boolean lazy) {
        if (null == gmoAgent) {
            return null;
        }
        Agent agent = new Agent();
        agent.setId(gmoAgent.getGmoAgentId());
        agent.setCin(gmoAgent.getGmoAgentCin());
        agent.setCode(gmoAgent.getGmoAgentCode() != null ? gmoAgent.getGmoAgentCode().toUpperCase() : null);
        agent.setBirthDate(gmoAgent.getGmoAgentBirthDate ());
        agent.setLastMedicalVisit(gmoAgent.getGmoAgentLastMedicalVisit());
       // agent.setCommission(gmoAgent.getGmoAgentCommission());
        agent.setWorking(gmoAgent.isGmoWorking());

        agent.setName(gmoAgent.getGmoAgentName());
        agent.setTele1(gmoAgent.getGmoAgentTele1());


        agent.setCreatedBy(gmoAgent.getCreatedBy());
        agent.setUpdatedBy(gmoAgent.getUpdatedBy());
        agent.setCreationDate(gmoAgent.getCreationDate());
        agent.setUpdateDate(gmoAgent.getUpdateDate());

        if (!lazy) {
         //   agent.setCommissions(CommissionAgentMapper.toDtos(gmoAgent.getGmoCommissions (), false));
            agent.setOwner(OwnerMapper.toDto(gmoAgent.getOwnOwner(), false));
            agent.setResponsability(ResponsabilityMapper.toDto(gmoAgent.getGmoResponsability(), false));

        }
        return agent;

    }


    public static List<Agent> toDtos(Iterable<? extends GmoAgent> gmoAgents, boolean lazy) {
        if (null == gmoAgents) {
            return null;
        }
        List<Agent> vehicules = new ArrayList<>();

        for (GmoAgent gmoAgent : gmoAgents) {
            vehicules.add(toDto(gmoAgent, lazy));
        }
        return vehicules;
    }

    public static Set<GmoAgent> toEntities(Set<Agent> agents, boolean lazy) {
        if (null == agents) {
            return null;
        }
        Set<GmoAgent> gmoAgents = new HashSet<>();
        for (Agent agent : agents) {
            gmoAgents.add(toEntity(agent, lazy));
        }
        return gmoAgents;
    }

    public static Set<Agent> toDtos(Set<GmoAgent> gmoAgents, boolean lazy) {
        if (null == gmoAgents) {
            return null;
        }
        Set<Agent> agents = new HashSet<>();
        for (GmoAgent gmoAgent : gmoAgents) {
            agents.add(toDto(gmoAgent, lazy));
        }
        return agents;
    }
}
