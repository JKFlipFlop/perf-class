package iaf.perf.course.day5;

import java.io.Serializable;

public class vcf implements Serializable{
//public class vcf{

	private String chrom;
	private int pos;
	private String ref;
	private String alt;
	private float qual;
	
	
	public vcf(String chrom, int pos, String ref, String alt, float qual) {
		super();
		this.chrom = chrom;
		this.pos = pos;
		this.ref = ref;
		this.alt = alt;
		this.qual = qual;
	}
	
	public String getChrom() {
		return chrom;
	}
	public void setChrom(String chrom) {
		this.chrom = chrom;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	public float getQual() {
		return qual;
	}
	public void setQual(float qual) {
		this.qual = qual;
	}
	

}
