package model;

public class Address {
	
	private Long id;
	private String streetName;
	private String streetNumber;
	private String neighborhoodName;
	private String cityName;
	private String state;
	private String country;
	private String postalNumer;
	
	public Address() {
		super();
	}

	public Address(Long id, String streetName, String streetNumber, String neighborhoodName, String cityName,
			String state, String country, String postalNumer) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.neighborhoodName = neighborhoodName;
		this.cityName = cityName;
		this.state = state;
		this.country = country;
		this.postalNumer = postalNumer;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getNeighborhoodName() {
		return neighborhoodName;
	}
	public void setNeighborhoodName(String neighborhoodName) {
		this.neighborhoodName = neighborhoodName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalNumer() {
		return postalNumer;
	}
	public void setPostalNumer(String postalNumer) {
		this.postalNumer = postalNumer;
	}
}
