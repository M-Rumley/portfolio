import java.math.BigInteger;
public class SolveEquation {
	static BigInteger LinearEquationSolver(BigInteger a,BigInteger b, BigInteger N){
		return (N.gcd(a).equals(BigInteger.ONE))?(a.modInverse(N).multiply(b.negate()).mod(N)):null;
	}
	
	public static void main(String[] args) {
		//Question 2a
		BigInteger N2a = new BigInteger("643808006803554439230129854961492699151386107534013432918073439524138264842370630061369715394739134090922937332590384720397133335969549256322620979036686633213903952966175107096769180017646161851573147596390153");
		BigInteger a2a= new BigInteger("34325464564574564564768795534569998743457687643234566579654234676796634378768434237897634345765879087764242354365767869780876543424");
		BigInteger b2a= new BigInteger("45292384209127917243621242398573220935835723464332452353464376432246757234546765745246457656354765878442547568543334677652352657235");
		System.out.println(LinearEquationSolver(a2a,b2a,N2a));
		//Question 2b
		BigInteger N2b = new BigInteger("342487235325934582350235837853456029394235268328294285895982432387582570234238487625923289526382379523573265963293293839298595072093573204293092705623485273893582930285732889238492377364284728834632342522323422");
		BigInteger a2b = new BigInteger("34325464564574564564768795534569998743457687643234566579654234676796634378768434237897634345765879087764242354365767869780876543424");
		BigInteger b2b = new BigInteger("24243252873562935279236582385723952735639239823957923562835832582635283562852252525256882909285959238420940257295265329820035324646");
		System.out.println(LinearEquationSolver(a2b,b2b,N2b));
		
		
		
	}

}
