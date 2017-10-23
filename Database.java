package SpriteAnimator;

public abstract class Database {
	/* taken and modified from
	 * http://alttp.mymm1.com/sprites/includes/animations.txt
	 * credit:
	 * Mike Trethewey
	 * TWRoxas
	 * Frame counts by: RyuTech
	 * format:
	 * [<ANIMNAME>]<INDEX>{<XPOS>,<YPOS>}{<SPRITESIZE>}{<TRANSFORM>}
	 * : delimits sprites in the same frame
	 * ; delimits entire frames
	 * @ at the end of each frame denotes how long it lasts
	 * Frames defined as "//" copy the previous frame
	 * SPRITESIZE is a flag determining what part of the sprite to draw from
	 *		F  : Full 16x16
	 *		T  : Top 16x8
	 *		B  : Bottom 16x8
	 *		R  : Right 8x16
	 *		L  : Left 8x16
	 *		TR : Top-right 8x8 ; alias : turtle rock
	 *		TL : Top-left 8x8
	 *		BR : Bottom-right 8x8
	 *		BL : Bottom-left 8x8
	 *		E  : Empty frame 0x0
	 * TRANSFORM is a flag determining how to flip the sprite
	 *		0  : No transform
	 *		U  : Mirror along X-axis
	 *		M  : Mirror along y-axis
	 *		UM : Mirror along both axes
	 */
	public static final String[] ALLFRAMES = {
			// stand TODO: 100% confirm
			"[stand]A0{-1,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 4",
			// standUp
			"[standUp]A2{0,0}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 4",
			// standDown
			"[standDown]A1{0,0}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 4",
			// walk TODO: 100% confirm
			"[walk]A0{-1,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{-1,-1}{F}{0}:B1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"K3{0,-1}{F}{0}:B2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"K4{-1,0}{F}{0}:Q7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"A0{-1,0}{F}{0}:S4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{-1,-1}{F}{0}:R6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"K3{0,-1}{F}{0}:R7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 1 ;" +
				"K4{0,0}{F}{0}:S3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 2 ",
			// walkUp TODO : Shield
			"[walkUp]A2{0,0}{F}{0}:B6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"A2{0,-1}{F}{0}:C0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-2}{F}{0}:S7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"A2{0,0}{F}{0}:T3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"A2{0,0}{F}{0}:T7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"A2{0,-1}{F}{0}:T4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-2}{F}{0}:T5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"A2{0,0}{F}{0}:T6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 1 ",
			// walkDown TODO : Check shield
			"[walkDown]SHIELD0{-4,7}{F}{0}:A1{0,0}{F}{0}:B4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"SHIELD0{-4,7}{F}{0}:A1{0,-1}{F}{0}:B5{0,8}{F}{0}:SHADOW0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"SHIELD0{-4,6}{F}{0}:A1{0,-2}{F}{0}:S5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"SHIELD0{-4,8}{F}{0}:A1{0,0}{F}{0}:S6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"SHIELD0{-4,8}{F}{0}:A1{0,0}{F}{0}:B4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"SHIELD0{-4,7}{F}{0}:A1{0,-1}{F}{0}:B5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"SHIELD0{-4,6}{F}{0}:A1{0,-2}{F}{0}:S5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"SHIELD0{-4,8}{F}{0}:A1{0,0}{F}{0}:S6{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 1 ",
			// bonk TODO: 100% confirm
			"[bonk]F3{0,0}{F}{0}:G3{0,16}{T}{0}:SHADOW0{0,16}{F}{0} @ 3 ",
			// bonkUp TODO: 100% confirm
			"[bonkUp]F4{0,0}{F}{0}:G4{0,16}{T}{0}:SHADOW0{0,16}{F}{0} @ 3 ",
			// bonkDown TODO: 100% confirm
			"[bonkDown]F2{0,0}{F}{0}:G2{0,16}{T}{0}:SHADOW0{0,16}{F}{0} @ 3 ",
			// swim TODO: 100% confirm
			"[swim]H5{0,-3}{F}{0}:I7{0,6}{F}{0} @ 3 ;" +
				"H6{0,-3}{F}{0}:J0{0,6}{F}{0} @ 3 ;" +
				"H5{0,-3}{F}{0}:I7{0,6}{F}{0} @ 3 ;" +
				"H7{0,-3}{F}{0}:J1{0,6}{F}{0} @ 3 ",
			// swimUp TODO: 100% confirm
			"[swimUp]A2{0,0}{F}{0}:I5{0,8}{F}{0} @ 3 ;" +
				"E4{0,0}{F}{0}:I6{0,8}{F}{0} @ 3 ",
			// swimDown TODO: 100% confirm
			"[swimDown]I3{0,-3}{F}{0}:J3{0,8}{F}{0} @ 3 ;" +
				"I4{0,-3}{F}{0}:J4{0,8}{F}{0} @ 3 ",
			// treadingWater TODO: 100% confirm
			"[treadingWater]A0{0,-3}{F}{0}:L0{2,3}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:L0{2,3}{F}{M} @ 3 ",
			// treadingWaterUp TODO: 100% confirm
			"[treadingWaterUp]A2{0,-3}{F}{0}:J2{0,7}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:J2{0,7}{F}{M} @ 3 ",
			// treadingWaterDown TODO: 100% confirm
			"[treadingWaterDown]A1{0,-3}{F}{0}:J2{0,7}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:J2{0,7}{F}{M} @ 3 ",
			// attack TODO: 100% confirm
			"[attack]A0{-1,1}{F}{0}:C2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"A0{-1,1}{F}{0}:C3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 1 ;" +
				"A0{1,1}{F}{0}:C3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 1 ;" +
				"A0{-1,1}{F}{0}:C4{0,8}{F}{0}:Z6{9,12}{BL}{0}:SHADOW0{0,8}{F}{0} @ 1 ;" +
				"A0{4,2}{F}{0}:α7{0,8}{F}{0}:Z6{15,13}{BL}{0}:SHADOW0{0,8}{F}{0} @ 4 ;" +
				"A0{1,2}{F}{0}:C4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 1 ;" +
				"A0{0,1}{F,1}{0}:C5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// attackUp TODO: 100% confirm
			"[attackUp]F1{0,0}{F}{0}:G1{0,16}{T}{0}:SHADOW0{0,8}{F}{0} @ 2;" +
				"A2{0,-1}{F}{0}:D1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"A2{0,-2}{F}{0}:D2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 1 ;" +
				"A2{0,-4}{F}{0}:β1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 4 ;" +
				"A2{0,-2}{F}{0}:D2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 1 ;" +
				"A2{0,0}{F}{0}:L4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// attackDown TODO: 100% confirm
			"[attackDown]F0{0,0}{F}{0}:G0{0,16}{T}{0}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"A1{0,2}{F}{0}:C6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"A4{0,2}{F}{0}:D0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 1 ;" +
				"A4{0,4}{F}{0}:β0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 4 ;" +
				"A4{0,2}{F}{0}:D0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 1 ;" +
				"A3{0,1}{F}{0}:L3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// dashRelease TODO: 100% confirm
			"[dashRelease]A0{0,0}{F}{0}:M6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K3{0,1}{F}{0}:V1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:M6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K4{0,2}{F}{0}:M7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// dashReleaseUp TODO: 100% confirm
			"[dashReleaseUp]A2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,1}{F}{0}:M4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,2}{F}{0}:M5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,1}{F}{0}:M4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,2}{F}{0}:M5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:M3{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ",
			// dashReleaseDown TODO: 100% confirm
			"[dashReleaseDown]A1{0,0}{F}{0}:M0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,1}{F}{0}:M1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,2}{F}{0}:M2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:M0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,1}{F}{0}:β2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,2}{F}{0}:β3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:M0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// spinAttack TODO: 100% confirm
			"[spinAttack]A0{0,-3}{F}{0}:I0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:P1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{M}:I0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:P3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{M}:B0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:P2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:I0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// spinAttackLeft TODO: 100% confirm
			"[spinAttackLeft]A0{0,-3}{F}{M}:I1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:P3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:P2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{M}:B0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{M}:I1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{M}:I2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{M}:I1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// spinAttackUp TODO: 100% confirm
			"[spinAttackUp]A2{0,-3}{F}{0}:D1{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"F1{0,-3}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:D1{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:P2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:P3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{M}:B0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:D1{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ",
			// spinAttackDown TODO: 100% confirm
			"[spinAttackDown]A1{0,-3}{F}{0}:C6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"F0{0,-3}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:C6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:P3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{M}:B0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:P2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:C6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// dashSpinup TODO: 100% confirm
			"[dashSpinup]A0{0,-3}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:B1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K3{0,-3}{F}{0}:B2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K4{0,-3}{F}{0}:Q7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:S4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:R6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K3{0,-3}{F}{0}:R7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K4{0,-3}{F}{0}:S3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:B1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K3{0,-3}{F}{0}:B2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K4{0,-3}{F}{0}:Q7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:S4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:R6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K3{0,-3}{F}{0}:R7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K4{0,-3}{F}{0}:S3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:B1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K3{0,-3}{F}{0}:B2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K4{0,-3}{F}{0}:Q7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:S4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:R6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K3{0,-3}{F}{0}:R7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K4{0,-3}{F}{0}:S3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// dashSpinupUp TODO: 100% confirm
			"[dashSpinupUp]A2{0,-3}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:B6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:C0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:S7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:T3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:T7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:T4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:T5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:T6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:B6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:C0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:S7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:T3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:T7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:T4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:T5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:T6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:B6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:C0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:S7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:T3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:T7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:T4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:T5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// dashSpinupDown TODO: 100% confirm
			"[dashSpinupDown]A1{0,-3}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:B4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:B5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:S5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:S6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:B4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:B5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:S5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:S6{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:B4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:B5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:S5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:S6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:B4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:B5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:S5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:S6{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:B4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:B5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:S5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:S6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:B4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:B5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:S5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:S6{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ",
			// salute TODO: 100% confirm
			"[salute]SWORD1{9,-6}{F}{M}:SHIELD0{-5,9}{F}{0}:A3{0,0}{F}{0}:P4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ",
			// itemGet TODO: 100% confirm
			"[itemGet]L1{0,0}{F}{0}:L2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// triforceGet TODO: 100% confirm
			"[triforceGet]Z2{0,0}{F}{0}:β4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// readBook TODO: 100% confirm
			"[readBook]K5{0,0}{F}{0}:K6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// prayer R1,A5:Q1,A5:Q0,S1
			"[prayer]R1{0,0}{F}{0}:S1{0,16}{T}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A5{0,1}{F}{0}:Q1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A5{0,1}{F}{0}:Q0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"S1{0,0}{B}{0}:T1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// fall TODO: 100% confirm
			"[fall]G0{0,0}{B}{0}:G1{16,0}{BL}{0}:H0{0,8}{F}{0}:H1{16,8}{L}{0} @ 3 ;" +
				"E5{0,0}{F}{0} @ 3 ;" +
				"E6{0,0}{F}{0} @ 3 ;" +
				"H4{0,0}{TR}{0} @ 3 ;" +
				"H4{0,0}{BR}{0} @ 3 ;" +
				"G4{0,0}{BR}{0} @ 3 ;" +
				"G4{0,0}{E}{0} @ 3 ",
			// grab TODO: 100% confirm
			"[grab]A0{0,-3}{F}{0}:X2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"Z3{0,-3}{F}{0}:Z4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// grabUp TODO: 100% confirm
			"[grabUp]Z0{0,-3}{F}{0}:V5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"Y6{0,-3}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// grabDown TODO: 100% confirm
			"[grabDown]E3{0,-3}{F}{0}:X5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U0{0,-3}{F}{0}:P7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// lift TODO: 100% confirm
			"[lift]E2{2,2}{F}{0}:U5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U1{-1,2}{F}{0}:U6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L6{-1,0}{F}{0}:O2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// liftUp TODO: 100% confirm
			"[liftUp]U2{0,-3}{F}{0}:U7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:V0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L7{0,-3}{F}{0}:O5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// liftDown TODO: 100% confirm
			"[liftDown]U0{0,-3}{F}{0}:U4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U0{0,-3}{F}{0}:U3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L5{0,-3}{F}{0}:N7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// carry TODO: 100% confirm
			"[carry]L6{0,-3}{F}{0}:O2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L6{0,-3}{F}{0}:O3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L6{0,-3}{F}{0}:O4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// carryUp TODO: 100% confirm
			"[carryUp]L7{0,-3}{F}{0}:O5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L7{0,-3}{F}{0}:O6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L7{0,-3}{F}{0}:O7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// carryDown TODO: 100% confirm
			"[carryDown]L5{0,-3}{F}{0}:N7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L5{0,-3}{F}{0}:O0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L5{0,-3}{F}{0}:O1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// treePull TODO: 100% confirm
			"[treePull]P7{0,-3}{F}{UM}:E7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"N0{0,-3}{F}{0}:A1{0,8}{F}{UM}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K2{0,-3}{F}{0}:K0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K1{0,-3}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"F4{0,-3}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"N0{0,-3}{F}{0}:A1{0,8}{F}{UM}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K2{0,-3}{F}{0}:K0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K1{0,-3}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// throw TODO: 100% confirm
			"[throw]A0{0,-3}{F}{0}:M6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// throwUp TODO: 100% confirm
			"[throwUp]A2{0,-3}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// throwDown TODO: 100% confirm
			"[throwDown]A1{0,-3}{F}{0}:M0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// push TODO: 100% confirm
			"[push]U1{0,0}{F}{0}:X2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U1{0,1}{F}{0}:X3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U1{0,2}{F}{0}:X4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U1{0,0}{F}{0}:X2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U1{0,1}{F}{0}:X3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U1{0,0}{F}{0}:X2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U1{0,1}{F}{0}:X3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U1{0,2}{F}{0}:X4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// pushUp TODO: 100% confirm
			"[pushUp]U2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U2{0,1}{F}{0}:M4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U2{0,2}{F}{0}:M5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U2{0,1}{F}{0}:M4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U2{0,1}{F}{0}:M4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U2{0,2}{F}{0}:M5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// pushDown TODO: 100% confirm
			"[pushDown]U0{0,3}{F}{0}:X5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U0{0,4}{F}{0}:X6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U0{0,5}{F}{0}:X7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U0{0,3}{F}{0}:X5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U0{0,4}{F}{0}:X6{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U0{0,3}{F}{0}:X5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U0{0,4}{F}{0}:X6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U0{0,5}{F}{0}:X7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// shovel TODO: 100% confirm
			"[shovel]B7{0,-1}{F}{0}:D7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:F5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{-1,0}{F}{0}:C7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// boomerang TODO: 100% confirm
			"[boomerang]S2{0,-3}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:C4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// boomerangUp TODO: 100% confirm
			"[boomerangUp]R2{0,-3}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:Q6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// boomerangDown TODO: 100% confirm
			"[boomerangDown]A1{0,-3}{F}{0}:Q5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:D0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// rod TODO: 100% confirm
			"[rod]G2{0,-3}{BR}{0}:G3{8,0}{BL}{0}:H2{0,8}{R}{0}:H3{8,8}{L}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:N4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// rodUp TODO: 100% confirm
			"[rodUp]G1{0,-3}{BR}{0}:G2{8,0}{BL}{0}:H1{0,8}{R}{0}:H2{8,8}{L}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:D2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:N5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// rodDown TODO: 100% confirm
			"[rodDown]G3{0,-3}{BR}{0}:G4{8,0}{BL}{0}:H3{0,8}{R}{0}:H4{8,8}{L}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:N6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:D0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// powder TODO: 100% confirm
			"[powder]A0{0,1}{F}{0}:C2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,1}{F}{0}:C3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,1}{F}{0}:C4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,1}{F}{0}:C5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// powderUp TODO: 100% confirm
			"[powderUp]F1{0,0}{F}{0}:G1{0,16}{T}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:D1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-1}{F}{0}:D2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:L4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// powderDown TODO: 100% confirm
			"[powderDown]F0{0,0}{F}{0}:G0{0,16}{T}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,1}{F}{0}:C6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A3{0,1}{F}{0}:D0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A3{0,1}{F}{0}:L3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// cane TODO: 100% confirm
			"[cane]A0{0,-3}{F}{0}:I2{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L1{0,-3}{F}{0}:O2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:C4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// caneUp TODO: 100% confirm
			"[caneUp]F1{0,-3}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:P5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:D2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// caneDown TODO: 100% confirm
			"[caneDown]F0{0,-3}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:P4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:D0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bow TODO: 100% confirm
			"[bow]A0{0,-3}{F}{0}:M6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:C4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:P6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bowUp TODO: 100% confirm
			"[bowUp]A2{0,-3}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:M4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-3}{F}{0}:P5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bowDown TODO: 100% confirm
			"[bowDown]A1{0,-3}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:B4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-3}{F}{0}:B4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bombos TODO: 100% confirm
			"[bombos]A1{0,0}{F}{0}:M0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{M}:M6{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:M6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:M0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{M}:M6{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:M6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:P3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:P4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:P3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,1}{F}{0}:L3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,2}{F}{0}:D0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 30 ",
			// ether TODO: 100% confirm
			"[ether]A1{0,0}{F}{0}:M0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{M}:M6{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:M6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:M0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{M}:M6{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:M6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:P3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A7{0,0}{F}{0}:P4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 30 ",
			// quake TODO: 100% confirm
			"[quake]A1{0,0}{F}{0}:M0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{M}:M6{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:M6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:M0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{M}:M6{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:M6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:P3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:P4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L5{0,0}{F}{0}:N7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,1}{F}{0}:Q1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 30 ",
			// hookshot TODO: 100% confirm
			"[hookshot]A0{0,-3}{F}{0}:C4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// hookshotUp TODO: 100% confirm
			"[hookshotUp]A2{0,-3}{F}{0}:D2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// hookshotDown TODO: 100% confirm
			"[hookshotDown]A1{0,-3}{F}{0}:D0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// zap TODO: 100% confirm
			"[zap]R0{0,0}{F}{0}:S0{0,16}{T}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"S0{0,0}{B}{0}:T0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bunnyStand TODO: 100% confirm
			"[bunnyStand]α4{0,-3}{F}{0}:α5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bunnyStandUp TODO: 100% confirm
			"[bunnyStandUp]α1{0,-3}{F}{0}:α2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bunnyStandDown TODO: 100% confirm
			"[bunnyStandDown]Z5{0,-3}{F}{0}:α0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bunnyWalk TODO: 100% confirm
			"[bunnyWalk]α4{0,-3}{F}{0}:α5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"α4{0,-3}{F}{0}:α6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bunnyWalkUp TODO: 100% confirm
			"[bunnyWalkUp]α1{0,-3}{F}{0}:α2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"α1{0,-3}{F}{0}:α3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bunnyWalkDown TODO: 100% confirm
			"[bunnyWalkDown]Z5{0,-3}{F}{0}:α0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"Z5{0,1}{F}{0}:Z7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// walkUpstairs1F TODO: 100% confirm
			"[walkUpstairs1F]A2{0,1}{F}{0}:V5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,2}{F}{0}:V6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"X1{0,-1}{F}{0}:Y3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"X1{0,0}{F}{0}:Y4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"X1{0,1}{F}{0}:Y5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"X1{0,-1}{F}{0}:Y3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"X1{0,0}{F}{0}:Y4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"X1{0,1}{F}{0}:Y5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"X1{0,-1}{F}{0}:Y3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"X1{0,0}{F}{0}:Y4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,2}{F}{0}:V2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{-1,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,2}{F}{0}:V2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{-1,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,2}{F}{0}:V2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{-1,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,2}{F}{0}:V2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{-1,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// walkDownstairs1F TODO: 100% confirm
			"[walkDownstairs1F]A0{0,2}{F}{M}:V2{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{1,0}{F}{M}:B0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,1}{F}{M}:V1{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"B7{0,0}{F}{M}:Y1{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"B7{0,1}{F}{M}:Y2{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"B7{0,-1}{F}{M}:Y0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"B7{0,0}{F}{M}:Y1{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"B7{0,1}{F}{M}:Y2{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"B7{0,-1}{F}{M}:Y0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"B7{0,0}{F}{M}:Y1{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,1}{F}{0}:V3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,2}{F}{0}:V4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,1}{F}{0}:V3{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,2}{F}{0}:V4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,1}{F}{0}:V3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,2}{F}{0}:V4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,1}{F}{0}:V3{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:S6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,1}{F}{0}:B3{0,9}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// walkUpstairs2F TODO: 100% confirm
			"[walkUpstairs2F]A0{0,0}{F}{0}:B0{1,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,1}{F}{0}:V1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"B7{0,0}{F}{0}:Y1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"B7{0,1}{F}{0}:Y2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"B7{0,-1}{F}{0}:Y0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"B7{0,0}{F}{0}:Y1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"B7{0,1}{F}{0}:Y2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"B7{0,-1}{F}{0}:Y0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"B7{0,0}{F}{0}:Y1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"B7{0,1}{F}{0}:Y2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,1}{F}{0}:V3{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,2}{F}{0}:V4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,1}{F}{0}:V3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,2}{F}{0}:V4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// walkDownstairs2F TODO: 100% confirm
			"[walkDownstairs2F]A2{0,0}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,1}{F}{0}:V5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,2}{F}{0}:V6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,1}{F}{0}:D4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,2}{F}{0}:M5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,1}{F}{0}:V5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"X1{0,0}{F}{M}:Y4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"X1{0,1}{F}{M}:Y5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"X1{0,-1}{F}{M}:Y3{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"X1{0,0}{F}{M}:Y4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"X1{0,1}{F}{M}:Y5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"X1{0,-1}{F}{M}:Y3{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"X1{0,0}{F}{M}:Y4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"X1{0,1}{F}{M}:Y5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"X1{0,-1}{F}{M}:Y3{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{1,0}{F}{M}:B0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,1}{F}{M}:V1{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,2}{F}{M}:V2{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{1,0}{F}{M}:B0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,1}{F}{M}:V1{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,2}{F}{M}:V2{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{1,0}{F}{M}:B0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,1}{F}{M}:V1{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,2}{F}{M}:V2{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{1,0}{F}{M}:B0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,1}{F}{M}:V1{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,2}{F}{M}:V2{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{1,0}{F}{M}:B0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ",
			// deathSpin TODO: 100% confirm
			"[deathSpin]A1{0,0}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{1,0}{F}{M}:B0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{-1,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{1,0}{F}{M}:B0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{-1,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{1,0}{F}{M}:B0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{-1,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"E2{2,0}{F}{0}:J5{0,8}{R}{0}:J6{8,8}{L}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"J6{8,8}{R}{0}:J7{16,8}{F}{0} @ 3 ",
			// deathSplat TODO: 100% confirm
			"[deathSplat]E2{2,0}{F}{0}:J5{0,8}{R}{0}:J6{8,8}{L}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"J6{8,8}{R}{0}:J7{16,8}{F}{0} @ 3 ",
			// poke TODO: 100% confirm
			"[poke]A0{0,-3}{F}{0}:N3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:N2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,-3}{F}{0}:F6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// pokeUp TODO: 100% confirm
			"[pokeUp]E4{0,0}{F}{0}:D2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"E4{0,1}{F}{0}:F7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"E4{0,1}{F}{0}:L4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// pokeDown TODO: 100% confirm
			"[pokeDown]A1{0,1}{F}{0}:N1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"E3{0,2}{F}{0}:G7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// tallGrass TODO: 100% confirm
			"[tallGrass]A0{-1,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{-1,1}{F}{0}:V1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{-1,2}{F}{0}:V2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// tallGrassUp TODO: 100% confirm
			"[tallGrassUp]A2{0,1}{F}{0}:V5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,2}{F}{0}:V6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,1}{F}{0}:D4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,2}{F}{0}:M5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ",
			// tallGrassDown TODO: 100% confirm
			"[tallGrassDown]A1{0,0}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,1}{F}{0}:V3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,2}{F}{0}:V4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// mapDungeon TODO: 100% confirm
			"[mapDungeon]K7{0,0}{F}{0} @ 3 ",
			// mapWorld TODO: 100% confirm
			"[mapWorld]Y7{0,0}{F}{0} @ 3; " +
				"Y7{0,0}{E}{0} @ 3 ",
			// sleep TODO: 100% confirm
			"[sleep]A6{0,0}{F}{0}:D3{0,5}{F}{0} @ 3 ",
			// awake TODO: 100% confirm
			"[awake]E3{0,0}{F}{0}:D3{0,7}{F}{0} @ 3 "
		};
}