package com.laborintos.prueba.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the geolocation database table.
 * 
 */
@Entity
public class Geolocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_geolocation")
	private Long idGeolocation;

	@Column(name = "latitud")
	private String lat;

	@Column(name = "longitud")
	private String lng;

	// bi-directional many-to-one association to Address
	@OneToMany(mappedBy = "geo")
	private List<Address> addresses;

	public Geolocation() {
	}

	public Long getIdGeolocation() {
		return idGeolocation;
	}

	public void setIdGeolocation(Long idGeolocation) {
		this.idGeolocation = idGeolocation;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setGeo(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setGeo(null);

		return address;
	}

}