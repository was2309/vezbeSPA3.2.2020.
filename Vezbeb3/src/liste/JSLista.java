package liste;

public class JSLista {
	CvorJSListe prvi;
	
	public void ubaciNaPocetak(int podatak,CvorJSListe prvi) {
		this.prvi=new CvorJSListe(podatak, this.prvi);	
	}
	
	public void ubaciNaKraj(int podatak) {
		if(prvi==null) {			
			this.prvi=new CvorJSListe(podatak, null);
		}else {
			CvorJSListe pom=this.prvi;
			while(pom.sledeci!=null) {
				pom=pom.sledeci;
			}
			pom.sledeci=new CvorJSListe(podatak, null);		
		}
	}
	
	public int izbaciSaPocetka() throws Exception {
		if(this.prvi==null) {
			throw new Exception("Nema elemenata u listi");
		}
		int a=this.prvi.podatak;
		this.prvi=prvi.sledeci;
		return a;
				
	}
	
	public void ispisi() {
		CvorJSListe pom=this.prvi;
		while(pom!=null) {
			System.out.println(pom.podatak);
			pom=pom.sledeci;
		}
	}
	
	public int izbaciSaKraja() throws Exception {
		if(this.prvi==null) {
			throw new Exception("Nema elemenata u listi");
		}
		if(prvi.sledeci==null) {
			int a=prvi.podatak;
			prvi=null;
			return a;
		}
		
		/*CvorJSListe pom=this.prvi,prethodni=null;
		while(pom.sledeci!=null) {
			prethodni=pom;
			pom=pom.sledeci;
		}
		int r=pom.podatak;
		prethodni.sledeci=null;
		return r;*/
		
		CvorJSListe pom=this.prvi;
		while(pom.sledeci.sledeci!=null) {
			pom=pom.sledeci;
		}
		int r=pom.sledeci.podatak;
		pom.sledeci=null;
		return r;
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		JSLista l = new JSLista();
		l.ubaciNaPocetak(5, l.prvi);
		l.ubaciNaPocetak(18, l.prvi);
		l.ubaciNaKraj(6);
		l.ubaciNaKraj(12);	
		l.ispisi();
		System.out.println();
		try {
			int saPocetka=l.izbaciSaPocetka();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			l.izbaciSaKraja();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l.ispisi();
	}
	
}
