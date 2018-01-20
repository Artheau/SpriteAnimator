package animator.database;

import org.json.*;

import animator.cellsearch.SpriteCell;

public class SpriteData {
	// class constants
	// Fighter, Master, Tempered, Butter
	private static final String[] SWORD_PREFIX = { "", "F", "M", "T", "B" };
	// Fighter, Red, Mirror
	private static final String[] SHIELD_PREFIX = { "", "F", "R", "M" };

	// local vars
	public final SheetRow row;
	public final int col;
	public final int x;
	public final int y;
	public final DrawSize d;
	public final boolean isEquipment;
	public final boolean isZap;
	public final Transformation t;
	public final String indexString;
	public final String listString;

	public SpriteData(JSONObject jo) {
		this(jo, 0);
	}

	// for swords and shields
	public SpriteData(JSONObject jo, int level) {
		String rowName = jo.getString("row");
		SheetRow passedRow = SheetRow.valueOf(rowName);

		if (passedRow == SheetRow.SWORD) {
			row = SheetRow.valueOf(SWORD_PREFIX[level] + rowName);
		} else if (passedRow == SheetRow.SHIELD) {
			row = SheetRow.valueOf(SHIELD_PREFIX[level] + rowName);
		} else {
			row = passedRow;
		}

		col = jo.getInt("col");
		JSONArray pos = jo.getJSONArray("pos");
		x = pos.getInt(0);
		y = pos.getInt(1);
		d = DrawSize.valueOf(jo.getString("size"));

		isEquipment = row.isEquipment;

		boolean zap;
		try {
			zap = jo.getBoolean("useZapMail");
		} catch (JSONException e) {
			zap = false;
		}
		isZap = zap;

		Transformation t1;
		try {
			t1 = Transformation.valueOf(jo.getString("trans"));
		} catch (JSONException e) {
			t1 = null;
		}

		t = t1;

		String ret = String.format("%s%s", this.row.name(), this.col);

		boolean showSize = !(d == DrawSize.FULL || d == DrawSize.EMPTY);
		if (showSize) {
			ret = String.format("%s:%s", ret, d.token);
		}

		boolean showTrans = t1 != null;
		if (showTrans) {
			ret = String.format("%s:%s", ret, t.token);
		}

		if (isZap) {
			ret = String.format("%s:Z", ret);
		}

		indexString = row + "" + col;
		listString = ret;
	}

	// compares all data points
	public boolean equals(Object o) {
		if (!(o instanceof SpriteData)) {
			return false;
		}
		assert o instanceof SpriteData;
		SpriteData s = (SpriteData) o;
		return (this.row == s.row) &&
				(this.col == s.col) &&
				(this.x == s.x) &&
				(this.y == s.y) &&
				(this.d == s.d) &&
				(this.isZap == s.isZap);
	}

	public boolean equalsIndex(SpriteCell cell) {
		return (this.row == cell.row &&
				this.col == cell.c &&
				this.d == cell.d);

	}

	public boolean isEmpty() {
		return d == DrawSize.EMPTY;
	}

	public boolean isLinkPart() {
		return row.isLinkPart;
	}

	public String toIndexString() {
		return indexString;
	}

	public String toList() {
		return listString;
	}
}