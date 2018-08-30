package aicw;

public class mapGen {
	private int[][][] map;
	private int _xRange;
	private int _yRange;
	private int _zRange;

	public mapGen(int x, int y, int z) {
		_xRange = x;
		_yRange = y;
		_zRange = z;
		map = new int[x][y][z];
		fillMap();
	}

	/**
	 * makes everyvalue in the array 0
	 */
	public void fillMap() {
		for (int i = 0; i < _xRange; ++i) {
			for (int j = 0; j < _yRange; ++j) {
				for (int k = 0; k < _zRange; ++k) {
					map[i][j][k] = 0;
				}
			}
		}
	}

	/**
	 * Adds obstical from your specifications
	 * 
	 * @param fromX
	 * @param toX
	 * @param fromY
	 * @param toY
	 * @param fromZ
	 * @param toZ
	 */
	public void addObstical(int fromX, int toX, int fromY, int toY, int fromZ,
			int toZ) {

		// obsticals are treated as 1s.
		for (int i = fromX; i <= toX; ++i) {
			for (int j = fromY; j <= toY; ++j) {
				for (int k = fromZ; k <= toZ; ++k) {
					map[i][j][k] = 1;
				}
			}
		}
	}

	// not using this atm
	public int[][][] getMap() {
		return map;
	}

	public String getCoord() {
		String coord ="";
		for (int xCord = 0; xCord < _xRange; ++xCord) {
			for (int yCord = 0; yCord < _yRange; ++yCord) {
				for (int zCord = 0; zCord < _zRange; ++zCord) {

					// if its not an obstical
					if (map[xCord][yCord][zCord] == 0) {
						coord +=" "+ xCord + "_" + yCord + "_" + zCord;
					}
				}
			}
		}
		return coord;
	}

	/**
	 * get all the paths
	 * 
	 * @return the paths available
	 */
	public String getPaths() {
		String pathString = "";
		for (int xCord = 0; xCord < _xRange; ++xCord) {
			for (int yCord = 0; yCord < _yRange; ++yCord) {
				for (int zCord = 0; zCord < _zRange; ++zCord) {

					// if its not an obstical
					if (map[xCord][yCord][zCord] == 0) {
						// check all the avaialable paths for that point, but
						// first figure out where the point is

						// start point
						if (xCord == 0 && yCord == 0 && zCord == 0) {

							pathString = pathString
									+ checkVerticalUp(xCord, yCord, zCord);
							pathString = pathString
									+ checkRight(xCord, yCord, zCord);
							pathString = pathString
									+ checkForward(xCord, yCord, zCord);

						}
						// check corner
						else if (xCord == (_xRange - 1)
								&& yCord == (_yRange - 1) && zCord == 0) {

							pathString = pathString
									+ checkVerticalUp(xCord, yCord, zCord);
							pathString = pathString
									+ checkLeft(xCord, yCord, zCord);
							pathString = pathString
									+ checkBackward(xCord, yCord, zCord);
						}

						// check corner
						else if (xCord == (_xRange - 1) && yCord == 0
								&& zCord == 0) {
							pathString = pathString
									+ checkVerticalUp(xCord, yCord, zCord);
							pathString = pathString
									+ checkLeft(xCord, yCord, zCord);
							pathString = pathString
									+ checkForward(xCord, yCord, zCord);
						}

						// check corner
						else if (xCord == 0 && yCord == (_yRange - 1)
								&& zCord == 0) {
							checkVerticalUp(xCord, yCord, zCord);
							pathString = pathString
									+ checkRight(xCord, yCord, zCord);
							pathString = pathString
									+ checkBackward(xCord, yCord, zCord);
						}

						// check corner
						else if (xCord == 0 && yCord == (_yRange - 1)
								&& zCord == (_zRange - 1)) {
							pathString = pathString
									+ checkVerticalDown(xCord, yCord, zCord);
							pathString = pathString
									+ checkRight(xCord, yCord, zCord);
							pathString = pathString
									+ checkBackward(xCord, yCord, zCord);

						}

						// check corner
						else if (xCord == 0 && yCord == 0
								&& zCord == (_zRange - 1)) {
							pathString = pathString
									+ checkVerticalDown(xCord, yCord, zCord);
							pathString = pathString
									+ checkRight(xCord, yCord, zCord);
							pathString = pathString
									+ checkForward(xCord, yCord, zCord);

						}

						// check corner
						else if (xCord == (_xRange - 1)
								&& yCord == (_yRange - 1)
								&& zCord == (_zRange - 1)) {
							pathString = pathString
									+ checkVerticalDown(xCord, yCord, zCord);
							pathString = pathString
									+ checkLeft(xCord, yCord, zCord);
							pathString = pathString
									+ checkBackward(xCord, yCord, zCord);
							//

						}

						// check corner
						else if (xCord == (_xRange - 1) && yCord == 0
								&& zCord == (_zRange - 1)) {
							pathString = pathString
									+ checkVerticalDown(xCord, yCord, zCord);
							pathString = pathString
									+ checkLeft(xCord, yCord, zCord);
							pathString = pathString
									+ checkForward(xCord, yCord, zCord);
						}

						// checking edge
						else if (xCord == 0 & zCord == 0) {
							pathString = pathString
									+ checkVerticalUp(xCord, yCord, zCord);
							pathString = pathString
									+ checkBackward(xCord, yCord, zCord);
							pathString = pathString
									+ checkForward(xCord, yCord, zCord);
							pathString = pathString
									+ checkRight(xCord, yCord, zCord);
						}

						// checking edge
						else if (xCord == 0 & zCord == (_zRange - 1)) {
							pathString = pathString
									+ checkBackward(xCord, yCord, zCord);
							pathString = pathString
									+ checkVerticalDown(xCord, yCord, zCord);
							pathString = pathString
									+ checkForward(xCord, yCord, zCord);
							pathString = pathString
									+ checkRight(xCord, yCord, zCord);
						}

						// checking edge
						else if (xCord == 0 & yCord == 0) {
							pathString = pathString
									+ checkVerticalUp(xCord, yCord, zCord);
							pathString = pathString
									+ checkForward(xCord, yCord, zCord);
							pathString = pathString
									+ checkVerticalDown(xCord, yCord, zCord);
							pathString = pathString
									+ checkRight(xCord, yCord, zCord);
						}

						// checking edge
						else if (xCord == 0 & yCord == (_yRange - 1)) {
							pathString = pathString
									+ checkVerticalUp(xCord, yCord, zCord);
							pathString = pathString
									+ checkVerticalDown(xCord, yCord, zCord);
							pathString = pathString
									+ checkBackward(xCord, yCord, zCord);
							pathString = pathString
									+ checkRight(xCord, yCord, zCord);
						}

						// checking edge
						else if (xCord == (_xRange - 1) & yCord == 0) {
							pathString = pathString
									+ checkVerticalUp(xCord, yCord, zCord);
							pathString = pathString
									+ checkVerticalDown(xCord, yCord, zCord);
							pathString = pathString
									+ checkForward(xCord, yCord, zCord);
							pathString = pathString
									+ checkLeft(xCord, yCord, zCord);
						}

						// checking edge
						else if (xCord == (_xRange - 1)
								& yCord == (_yRange - 1)) {
							pathString = pathString
									+ checkVerticalUp(xCord, yCord, zCord);
							pathString = pathString
									+ checkVerticalDown(xCord, yCord, zCord);
							pathString = pathString
									+ checkBackward(xCord, yCord, zCord);
							pathString = pathString
									+ checkLeft(xCord, yCord, zCord);
						}
						// checking edge
						else if (xCord == (_xRange - 1) & zCord == 0) {
							pathString = pathString
									+ checkVerticalUp(xCord, yCord, zCord);
							pathString = pathString
									+ checkForward(xCord, yCord, zCord);
							pathString = pathString
									+ checkBackward(xCord, yCord, zCord);
							pathString = pathString
									+ checkLeft(xCord, yCord, zCord);
						} else if (xCord == (_xRange - 1)
								& zCord == (_zRange - 1)) {
							pathString = pathString
									+ checkVerticalDown(xCord, yCord, zCord);
							pathString = pathString
									+ checkForward(xCord, yCord, zCord);
							pathString = pathString
									+ checkBackward(xCord, yCord, zCord);
							pathString = pathString
									+ checkLeft(xCord, yCord, zCord);
						}

						// checking edge
						else if (yCord == 0 & zCord == 0) {
							pathString = pathString
									+ checkVerticalUp(xCord, yCord, zCord);
							pathString = pathString
									+ checkForward(xCord, yCord, zCord);
							pathString = pathString
									+ checkLeft(xCord, yCord, zCord);
							pathString = pathString
									+ checkRight(xCord, yCord, zCord);
						}

						// checking edge
						else if (yCord == 0 & zCord == (_zRange - 1)) {
							pathString = pathString
									+ checkVerticalDown(xCord, yCord, zCord);
							pathString = pathString
									+ checkForward(xCord, yCord, zCord);
							pathString = pathString
									+ checkLeft(xCord, yCord, zCord);
							pathString = pathString
									+ checkRight(xCord, yCord, zCord);
						}

						// checking edge
						else if (yCord == (_yRange - 1) & zCord == 0) {
							pathString = pathString
									+ checkVerticalUp(xCord, yCord, zCord);
							pathString = pathString
									+ checkBackward(xCord, yCord, zCord);
							pathString = pathString
									+ checkLeft(xCord, yCord, zCord);
							pathString = pathString
									+ checkRight(xCord, yCord, zCord);
						}

						// checkedge
						else if (yCord == (_yRange - 1)
								& zCord == (_zRange - 1)) {
							pathString = pathString
									+ checkVerticalDown(xCord, yCord, zCord);
							pathString = pathString
									+ checkBackward(xCord, yCord, zCord);
							pathString = pathString
									+ checkLeft(xCord, yCord, zCord);
							pathString = pathString
									+ checkRight(xCord, yCord, zCord);
						}

						// check surface
						else if (xCord == 0) {
							pathString = pathString
									+ checkVerticalDown(xCord, yCord, zCord);
							pathString = pathString
									+ checkForward(xCord, yCord, zCord);
							pathString = pathString
									+ checkVerticalUp(xCord, yCord, zCord);
							pathString = pathString
									+ checkBackward(xCord, yCord, zCord);
							pathString = pathString
									+ checkRight(xCord, yCord, zCord);
						}

						// check surface
						else if (xCord == (_xRange - 1)) {
							pathString = pathString
									+ checkVerticalDown(xCord, yCord, zCord);
							pathString = pathString
									+ checkForward(xCord, yCord, zCord);
							pathString = pathString
									+ checkVerticalUp(xCord, yCord, zCord);
							pathString = pathString
									+ checkLeft(xCord, yCord, zCord);
							pathString = pathString
									+ checkBackward(xCord, yCord, zCord);

						}

						// check surface
						else if (yCord == 0) {
							pathString = pathString
									+ checkVerticalDown(xCord, yCord, zCord);
							pathString = pathString
									+ checkForward(xCord, yCord, zCord);
							pathString = pathString
									+ checkVerticalUp(xCord, yCord, zCord);
							pathString = pathString
									+ checkLeft(xCord, yCord, zCord);
							pathString = pathString
									+ checkRight(xCord, yCord, zCord);
						}

						// check surface
						else if (yCord == (_yRange - 1)) {
							pathString = pathString
									+ checkVerticalDown(xCord, yCord, zCord);
							pathString = pathString
									+ checkBackward(xCord, yCord, zCord);
							pathString = pathString
									+ checkVerticalUp(xCord, yCord, zCord);
							pathString = pathString
									+ checkLeft(xCord, yCord, zCord);
							pathString = pathString
									+ checkRight(xCord, yCord, zCord);

						}

						// check surface
						else if (zCord == 0) {
							pathString = pathString
									+ checkBackward(xCord, yCord, zCord);
							pathString = pathString
									+ checkForward(xCord, yCord, zCord);
							pathString = pathString
									+ checkVerticalUp(xCord, yCord, zCord);
							pathString = pathString
									+ checkLeft(xCord, yCord, zCord);
							pathString = pathString
									+ checkRight(xCord, yCord, zCord);
						}

						// check surface
						else if (zCord == (_zRange - 1)) {
							pathString = pathString
									+ checkVerticalDown(xCord, yCord, zCord);
							pathString = pathString
									+ checkForward(xCord, yCord, zCord);
							pathString = pathString
									+ checkBackward(xCord, yCord, zCord);
							pathString = pathString
									+ checkLeft(xCord, yCord, zCord);
							pathString = pathString
									+ checkRight(xCord, yCord, zCord);
						} else {
							pathString = pathString
									+ checkForward(xCord, yCord, zCord);
							pathString = pathString
									+ checkBackward(xCord, yCord, zCord);
							pathString = pathString
									+ checkLeft(xCord, yCord, zCord);
							pathString = pathString
									+ checkRight(xCord, yCord, zCord);
							pathString = pathString
									+ checkVerticalDown(xCord, yCord, zCord);
							pathString = pathString
									+ checkVerticalUp(xCord, yCord, zCord);
						}
					}
				}
			}
		}

		return pathString;
	}

	public String checkVerticalUp(int i, int j, int k) {
		if (map[i][j][k + 1] == 0) {
			int x = k + 1;
			return "(pathVerticalUp " + i + "_" + j + "_" + k + " " + i + "_"
					+ j + "_" + x + ") ";
		}
		return "";
	}

	public String checkVerticalDown(int i, int j, int k) {
		if (map[i][j][k - 1] == 0) {
			int x = k - 1;
			return "(pathVerticalDown " + i + "_" + j + "_" + k + " " + i + "_"
					+ j + "_" + x + ") ";
		}
		return "";
	}

	public String checkForward(int i, int j, int k) {
		if (map[i][j + 1][k] == 0) {
			int x = j + 1;
			return "(pathHorizontal " + i + "_" + j + "_" + k + " " + i + "_"
					+ x + "_" + k + ") ";
		}
		return "";
	}

	public String checkBackward(int i, int j, int k) {
		if (map[i][j - 1][k] == 0) {
			int x = j - 1;
			return "(pathHorizontal " + i + "_" + j + "_" + k + " " + i + "_"
					+ x + "_" + k + ") ";
		}
		return "";
	}

	public String checkRight(int i, int j, int k) {
		if (map[i + 1][j][k] == 0) {
			int x = i + 1;
			return "(pathHorizontal " + i + "_" + j + "_" + k + " " + x + "_"
					+ j + "_" + k + ") ";
		}
		return "";
	}

	public String checkLeft(int i, int j, int k) {
		if (map[i - 1][j][k] == 0) {
			int x = i - 1;
			return "(pathHorizontal " + i + "_" + j + "_" + k + " " + x + "_"
					+ j + "_" + k + ") ";
		}
		return "";
	}

}
