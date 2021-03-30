package com.juan.spidergames.domain;

public interface KakuroCell {
	
	/**
	 * Get the type of cell: BLACK, REFERENCE, OR WHITE
	 * @return CellType interface defined at the bottom of this interface
	 */
	CellType getCellType();
	
	/**
	 * If it is a Reference Cell, and has white cells on its right side, it will return the number indicating the sum
	 * of numbers on the right of the cell. If there are no white cells on the right side or if this cell is not
	 * a reference it must return null.
	 * @return Integer representing the sum of numbers on the white cells on the right side of the reference cell.
	 */
	default Integer getRightReference() {
		return null;
	};
	
	/**
	 * If it is a Reference Cell, and has white cells below it, it will return the number indicating the sum
	 * of numbers on the cells below. If there are no white cells below or if this cell is not
	 * a reference it must return null.
	 * @return Integer representing the sum of numbers on the white cells on the right side of the reference cell.
	 */
	default Integer getDownReference() {
		return null;
	};
	
	/**
	 * If it is a White Cell and someone is completing the kakuro and its status is in progress it will return the
	 * value the user has provided for the cell up to the moment. Otherwise it will return null.
	 * @return Integer 1-9 representing the value of the cell completed by the user.
	 */
	default Integer getValue() {
		return null;
	};
	
	
	public static enum CellType {
		BLACK, WHITE, REFERENCE;
		
//		public static String BLACK = "BLACK";
//		public static String WHITE = "WHITE";
//		public static String REFERENCE = "REFERENCE";
		
	}
	

}
