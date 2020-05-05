package com.bagile.tms.services.impl;

import com.bagile.gmo.entities.UsrGroupHabilitation;
import com.bagile.gmo.entities.UsrUser;
import com.bagile.gmo.entities.UsrUserGroupOwner;
import com.bagile.gmo.entities.UsrUserGroupWarehouse;
import com.bagile.tms.repositories.UserRepository;
import com.bagile.tms.services.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
@Transactional

public class MyUserDetailsService implements UserDetailsService, UserDetailsServiceWarehouse {

    private final UserRepository userRepository;
    private StringBuffer warehouses;
    private StringBuffer owners;
    private StringBuffer codeWarehouses;
    private StringBuffer habilitations;
    private StringBuffer codeOwners;
    private StringBuffer idOwners;
    private StringBuffer idWarehouses;
    private UserDetails userDetails;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {

        UsrUser user = userRepository.findByUsrUserEmail(username);
        if (!user.getUsrUserIsActive())
            user = null;
        List<GrantedAuthority> authorities = buildUserAuthority(user);
        userDetails = buildUserForAuthentication(user, authorities);
        return userDetails;
    }

    private User buildUserForAuthentication(UsrUser user,
                                            List<GrantedAuthority> authorities) {
        if (null != user) {
            return new User(user.getUsrUserName(), user.getUsrUserPassword(), true,
                    true, true, true, authorities);
        }
        return null;
    }

    private List<GrantedAuthority> buildUserAuthority(UsrUser user) {

        if (user != null) {
            warehouses = null;

            Set<UsrUserGroupWarehouse> usrUserGroupWrhWarehouses = user.getUsrUserGroup().getUsrUserGroupWrhWarehouses();
            if (null != usrUserGroupWrhWarehouses && usrUserGroupWrhWarehouses.size() != 0) {
                Iterator<UsrUserGroupWarehouse> groupWarehouse = usrUserGroupWrhWarehouses.iterator();
                warehouses = new StringBuffer();
                codeWarehouses = new StringBuffer();
                idWarehouses = new StringBuffer();
                UsrUserGroupWarehouse wrh = groupWarehouse.next();
                String wrhWarehouseCode = wrh.getWrhWarehouse().getWrhWarehouseCode();
                long wrhWarehouseId = wrh.getWrhWarehouse().getWrhWarehouseId();
                codeWarehouses.append("code<");
                codeWarehouses.append(wrhWarehouseCode);
                warehouses.append("warehouse.code<");
                warehouses.append(wrhWarehouseCode);
                idWarehouses.append(wrhWarehouseId);
                while (groupWarehouse.hasNext()) {
                    UsrUserGroupWarehouse warehouse = groupWarehouse.next();
                    wrhWarehouseCode = warehouse.getWrhWarehouse().getWrhWarehouseCode();
                    wrhWarehouseId = warehouse.getWrhWarehouse().getWrhWarehouseId();
                    warehouses.append(";");
                    warehouses.append(wrhWarehouseCode);
                    codeWarehouses.append(";");
                    codeWarehouses.append(wrhWarehouseCode);
                    idWarehouses.append(",");
                    idWarehouses.append(wrhWarehouseId);
                }
            }
            Set<UsrGroupHabilitation> usrGroupHabilitations = user.getUsrUserGroup().getUsrGroupHabilitations();

            if (null != usrGroupHabilitations && usrGroupHabilitations.size() != 0) {
                Iterator<UsrGroupHabilitation> usrGroupHabilitationIterator = usrGroupHabilitations.iterator();
                habilitations = new StringBuffer();
                String habilitationCode = usrGroupHabilitationIterator.next().getUsrHabilitation().getUsrHabilitationCode();
                habilitations.append("code<");
                habilitations.append(habilitationCode);
                while (usrGroupHabilitationIterator.hasNext()) {
                    habilitationCode = usrGroupHabilitationIterator.next().getUsrHabilitation().getUsrHabilitationCode();
                    habilitations.append(";");
                    habilitations.append(habilitationCode);
                }
            }

            Set<UsrUserGroupOwner> usrUserGroupOwners = user.getUsrUserGroup().getUsrUserGroupOwnOwners();
            if (null != usrUserGroupOwners && usrUserGroupOwners.size() != 0) {
                Iterator<UsrUserGroupOwner> groupOwnersIterator = usrUserGroupOwners.iterator();
                owners = new StringBuffer();
                codeOwners = new StringBuffer();
                idOwners = new StringBuffer();
                UsrUserGroupOwner usrGroup = groupOwnersIterator.next();
                String ownOwnerCode = usrGroup.getOwnOwner().getOwnOwnerCode();
                long ownOwnerId = usrGroup.getOwnOwner().getOwnOwnerId();
                owners.append("owner.active:true,owner.code<");
                owners.append(ownOwnerCode);
                codeOwners.append("code<");
                codeOwners.append(ownOwnerCode);
                idOwners.append(ownOwnerId);
                while (groupOwnersIterator.hasNext()) {
                    UsrUserGroupOwner usrGrp = groupOwnersIterator.next();
                    ownOwnerCode = usrGrp.getOwnOwner().getOwnOwnerCode();
                    ownOwnerId = usrGrp.getOwnOwner().getOwnOwnerId();
                    owners.append(";");
                    owners.append(ownOwnerCode);
                    codeOwners.append(";");
                    codeOwners.append(ownOwnerCode);
                    idOwners.append(",");
                    idOwners.append(ownOwnerId);
                }
            }


            Set<UsrGroupHabilitation> userRoles = user.getUsrUserGroup()
                    .getUsrGroupHabilitations();
            //Set<UsrHabilitation> usrHabilitation = user.getUsrUserGroup().getUsrHabilitation();
            List<GrantedAuthority> list = new ArrayList<>();
            //Iterator<UsrHabilitation> iterator = usrHabilitation.iterator();
            for (UsrGroupHabilitation groupHabilitation : userRoles) {
                list.add(groupHabilitation.getUsrHabilitation());
            }
//            while (iterator.hasNext()) {
////               / UsrHabilitation habilitation = i.next();
//                list.add(iterator.next());
//            }
            return list;
        }
        warehouses = null;
        return null;
    }

    @Override
    public StringBuffer getWarehouses() {
        return warehouses;
    }

    @Override
    public StringBuffer getOwners() {
        return owners;
    }

    public void setWarehouses(StringBuffer warehouses) {
        this.warehouses = warehouses;
    }

    public void setOwners(StringBuffer owners) {
        this.owners = owners;
    }

    @Override
    public StringBuffer getCodeWarehouses() {
        return codeWarehouses;
    }

    @Override
    public StringBuffer getCodeOwners() {
        return codeOwners;
    }

    @Override
    public StringBuffer getIdWarehouses() {
        return idWarehouses;
    }

    @Override
    public StringBuffer getIdOwners() {
        return idOwners;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public StringBuffer getHabilitations() {
        return habilitations;
    }

    public void setHabilitations(StringBuffer habilitations) {
        this.habilitations = habilitations;
    }
}