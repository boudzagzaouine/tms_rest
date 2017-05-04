/**
 * 
 */
package com.sinno.ems.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author aelguezzar
 *
 */
@Entity
public class DashResult implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4486235463788908433L;

	@Id
	private String warehouse;
	@Id
	private String owner;
	private String statusCode;
	@Id
	private long count;

	public DashResult() {
	}

	/**
	 * @param warehouse
	 * @param owner
	 * @param statusCode
	 * @param count
	 */
	public DashResult(String warehouse, String owner, String status,
			long count) {
		super();
		this.warehouse = warehouse;
		this.owner = owner;
		this.statusCode = status;
		this.count = count;
	}

	/**
	 * @return the warehouse
	 */
	@Column(name = "wrh_warehousecode")
	public String getWarehouse() {
		return warehouse;
	}

	/**
	 * @param warehouse the warehouse to set
	 */
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	/**
	 * @return the owner
	 */
	@Column(name = "own_ownercode")
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the statusCode
	 */
	@Column(name = "cmd_saleorderstatusid")
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String status) {
		this.statusCode = status;
	}

	/**
	 * @return the count
	 */
	@Column(name = "count")
	public long getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(long count) {
		this.count = count;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DashResult [");
		if (warehouse != null) {
			builder.append("warehouse=");
			builder.append(warehouse);
			builder.append(", ");
		}
		if (owner != null) {
			builder.append("owner=");
			builder.append(owner);
			builder.append(", ");
		}
		if (statusCode != null) {
			builder.append("statusCode=");
			builder.append(statusCode);
			builder.append(", ");
		}
		builder.append("count=");
		builder.append(count);
		builder.append("]");
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime * result
				+ ((warehouse == null) ? 0 : warehouse.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DashResult))
			return false;
		DashResult other = (DashResult) obj;
//		if (count == null) {
//			if (other.count != null)
//				return false;
//		} else if (!count.equals(other.count))
//			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		if (warehouse == null) {
			if (other.warehouse != null)
				return false;
		} else if (!warehouse.equals(other.warehouse))
			return false;
		return true;
	}

}