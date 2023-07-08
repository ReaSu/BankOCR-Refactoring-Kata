class Result {
	StringBuilder sb;

	Result() {
		sb = new StringBuilder();
	}

	void add(String next) {
		sb.append(next);
	}

	void addMarker() {
		String marker = "    ";
		if (isIllegal(sb)) {
			marker = " ILL";
		}
		sb.append(marker);
	}

	@Override
	public String toString() {
		return sb.toString();
	}

	private boolean isIllegal(StringBuilder sb) {
		return sb.indexOf("?") > -1;
	}
}
