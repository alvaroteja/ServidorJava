package Clases;

public class Producto {
	int idProducto, stockActual, stockMinimo; 
	String producto, descripcion;
	float pvp;
	public Producto(int idProducto, int stockActual, int stockMinimo, String producto, String descripcion, float pvp) {
		super();
		this.idProducto = idProducto;
		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;
		this.producto = producto;
		this.descripcion = descripcion;
		this.pvp = pvp;
	}
	public int getIdproducto() {
		return idProducto;
	}
	public void setIdproducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getStockActual() {
		return stockActual;
	}
	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}
	public int getStockMinimo() {
		return stockMinimo;
	}
	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPvp() {
		return pvp;
	}
	public void setPvp(float pvp) {
		this.pvp = pvp;
	}
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", stockActual=" + stockActual + ", stockMinimo=" + stockMinimo
				+ ", producto=" + producto + ", descripcion=" + descripcion + ", pvp=" + pvp + "]";
	}
}
