
public class Autot {

	private String autoId;
	private String rekisteriNro;
	private String autoMerkki;
	private String autoMalli;

	public Autot() {
		this.autoId = "null";
		this.rekisteriNro = "tuntematon";
		this.autoMerkki = "ei m‰‰ritelty";
		this.autoMalli = "ei m‰‰ritelty";
	}

	public Autot(String autoId, String rekisteriNro, String autoMerkki, String autoMalli) {
		super();
		this.autoId = autoId;
		this.rekisteriNro = rekisteriNro;
		this.autoMerkki = autoMerkki;
		this.autoMalli = autoMalli;
	}

	public String getRekisteriNro() {
		return rekisteriNro;
	}

	public void setRekisteriNro(String rekisteriNro) {
		this.rekisteriNro = rekisteriNro;
	}

	public String getAutoMerkki() {
		return autoMerkki;
	}

	public void setAutoMerkki(String autoMerkki) {
		this.autoMerkki = autoMerkki;
	}

	public String getAutoMalli() {
		return autoMalli;
	}

	public void setAutoMalli(String autoMalli) {
		this.autoMalli = autoMalli;
	}

	public String getAutoId() {
		return autoId;
	}

	public void setAutoId(String autoId) {
		this.autoId = autoId;
	}

	@Override
	public String toString() {
		
		String tiedot = "[rekisteriNro: " + rekisteriNro + ", autoMerkki: " + autoMerkki + ", autoMalli: " + autoMalli + "]";		
		return tiedot;
	}
	
}
