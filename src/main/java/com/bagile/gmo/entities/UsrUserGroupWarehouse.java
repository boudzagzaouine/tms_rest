package com.bagile.gmo.entities;

import javax.persistence.*;

@Entity
@Table(name = "usr_usergroup_wrh_warehouse")
public class UsrUserGroupWarehouse extends EmsEntity {

    private Long usrUserGroupWrhWarehouseId;
    private UsrUserGroup usrUserGroup;
    private WrhWarehouse wrhWarehouse;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_user_group_warehouse_id", allocationSize = 1)
    @Column(name = "usr_usergroup_wrh_warehouse_id", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getUsrUserGroupWrhWarehouseId() {
        return usrUserGroupWrhWarehouseId;
    }

    public void setUsrUserGroupWrhWarehouseId(Long usrUserGroupWrhWarehouseId) {
        this.usrUserGroupWrhWarehouseId = usrUserGroupWrhWarehouseId;
    }

    @ManyToOne
    @JoinColumn(name = "usr_usergroup_id", nullable = false)
    public UsrUserGroup getUsrUserGroup() {
        return usrUserGroup;
    }

    public void setUsrUserGroup(UsrUserGroup usrUserGroup) {
        this.usrUserGroup = usrUserGroup;
    }

    @ManyToOne
    @JoinColumn(name = "wrh_warehouse_id", nullable = false)
    public WrhWarehouse getWrhWarehouse() {
        return wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }
}
