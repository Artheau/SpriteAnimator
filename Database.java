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
			// stand TODO: 100% confirm ; A0:B0
			"[stand]A0{-1,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// standUp TODO: 100% confirm ; A2:C1
			"[standUp]A2{0,0}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// standDown TODO: 100% confirm ; A1:B3
			"[standDown]A1{0,0}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// walk TODO: 100% confirm ; A0:B0,A0:B1,K3:B2,K4:Q7,A0:S4,A0:R6,K3:R7,K4:S3
			"[walk]A0{-1,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:B1{1,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K3{0,0}{F}{0}:B2{1,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K4{0,0}{F}{0}:Q7{1,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:S4{1,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:R6{1,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K3{0,0}{F}{0}:R7{1,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K4{0,0}{F}{0}:S3{1,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;",
			// walkUp TODO: 100% confirm ; A2:B6,A2:C0,A2:S7,A2:T3,A2:T7,A2:T4,A2:T5,A2:T6
			"[walkUp]A2{0,0}{F}{0}:B6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:C0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:S7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// walkDown
			"[walkDown]A1{0,0}{F}{0}:B4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"A1{0,-1}{F}{0}:B5{0,8}{F}{0}:SHADOW0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,-2}{F}{0}:S5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:S6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"A1{0,0}{F}{0}:B4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"A1{0,-1}{F}{0}:B5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"A1{0,-2}{F}{0}:S5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 2 ;" +
				"A1{0,0}{F}{0}:S6{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 1 ",
			// bonk TODO: 100% confirm ; F3
			"[bonk]F3{0,0}{F}{0}:G3{0,16}{T}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bonkUp TODO: 100% confirm ; F4
			"[bonkUp]F4{0,0}{F}{0}:G4{0,16}{T}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bonkDown TODO: 100% confirm ; F2
			"[bonkDown]F2{0,0}{F}{0}:G2{0,16}{T}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// swim TODO: 100% confirm ; H5:I7,H6:J0,H5:I7,H7:J1
			"[swim]H5{0,0}{F}{0}:I7{0,6}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"H6{0,0}{F}{0}:J0{0,6}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"H5{0,0}{F}{0}:I7{0,6}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"H7{0,0}{F}{0}:J1{0,6}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// swimUp TODO: 100% confirm ; A2:I5,E4:I6
			"[swimUp]A2{0,0}{F}{0}:I5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"E4{0,0}{F}{0}:I6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// swimDown TODO: 100% confirm ; I3:J3,I4:J4
			"[swimDown]I3{0,0}{F}{0}:J3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"I4{0,0}{F}{0}:J4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// swimFlap TODO: 100% confirm ; P0,J5
			"[swimFlap]P0{0,0}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"J5{0,0}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// treadingWater TODO: 100% confirm ; A0:L0,A0:L0-M
			"[treadingWater]A0{0,0}{F}{0}:L0{2,3}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:L0{2,3}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ",
			// treadingWaterUp TODO: 100% confirm ; A2:J2,A2:J2-M
			"[treadingWaterUp]A2{0,0}{F}{0}:J2{0,7}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:J2{0,7}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ",
			// treadingWaterDown TODO: 100% confirm ; A1:J2,A1:J2-M
			"[treadingWaterDown]A1{0,0}{F}{0}:J2{0,7}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:J2{0,7}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ",
			// attack TODO: 100% confirm ; A0:C2,A0:C3,A0:C4,A0:α7,Z6,A0:C4,A0:C5
			"[attack]A0{0,0}{F}{0}:C2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:C3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:C4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:α7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"Z6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:C4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:C5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// attackUp TODO: 100% confirm ; F1,A2:D1,A2:D2,A2:β1,A2:D2,A2:L4
			"[attackUp]F1{0,0}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:D1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:D2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:β1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:D2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:L4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// attackDown TODO: 100% confirm ; F0,A1:C6,A4:D0,A4:β0,A4:D0,A3:L3
			"[attackDown]F0{0,0}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:C6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A4{0,0}{F}{0}:D0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A4{0,0}{F}{0}:β0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A4{0,0}{F}{0}:D0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A3{0,0}{F}{0}:L3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// dashRelease TODO: 100% confirm ; A0:M6,K3:V1,A0:M6,K4:M7
			"[dashRelease]A0{0,0}{F}{0}:M6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K3{0,1}{F}{0}:V1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:M6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K4{0,2}{F}{0}:M7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// dashReleaseUp TODO: 100% confirm ; A2:M3,A2:M4,A2:M5,A2:M3,A2:M4-M,A2:M5-M,A2:M3-M
			"[dashReleaseUp]A2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:M4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:M5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:M4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:M5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:M3{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ",
			// dashReleaseDown TODO: 100% confirm ; A1:M0,A1:M1,A1:M2,A1:M0,A1:β2,A1:β3,A1:M0
			"[dashReleaseDown]A1{0,0}{F}{0}:M0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:M1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:M2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:M0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:β2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:β3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:M0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// spinAttack TODO: 100% confirm ; A0:I0,A0:P1,A0-M:I0,A0:B0,A1:P3,A0-M:B0-M,A2:P2,A0:I0
			"[spinAttack]A0{0,0}{F}{0}:I0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:P1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{M}:I0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:P3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{M}:B0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:P2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:I0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// spinAttackLeft TODO: 100% confirm ; A0-M:I1,A1:P3,A0:B0,A2:P2,A0-M:B0-M,A0-M:I1,A0-M:I2,A0-M:I1
			"[spinAttackLeft]A0{0,0}{F}{M}:I1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:P3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:P2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{M}:B0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{M}:I1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{M}:I2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{M}:I1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// spinAttackUp TODO: 100% confirm ; A2:D1-M,F1-M,A2:D1-M,A2:P2,A0:B0,A1:P3,A0-M:B0-M,A2:D1-M
			"[spinAttackUp]A2{0,0}{F}{0}:D1{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"F1{0,0}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:D1{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:P2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:P3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{M}:B0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:D1{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ",
			// spinAttackDown TODO: 100% confirm ; A1:C6,F0,A1:C6,A1:P3,A0-M:B0-M,A2:P2,A0:B0,A1:C6
			"[spinAttackDown]A1{0,0}{F}{0}:C6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"F0{0,0}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:C6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:P3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{M}:B0{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:P2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:C6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// dashSpinup TODO: 100% confirm ; A0:B0,A0:B1,K3:B2,K4:Q7,A0:S4,A0:R6,K3:R7,K4:S3,A0:B0,A0:B1,K3:B2,K4:Q7,A0:S4,A0:R6,K3:R7,K4:S3,A0:B0,A0:B1,K3:B2,K4:Q7,A0:S4,A0:R6,K3:R7,K4:S3
			"[dashSpinup]A0{0,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:B1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K3{0,0}{F}{0}:B2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K4{0,0}{F}{0}:Q7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:S4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:R6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K3{0,0}{F}{0}:R7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K4{0,0}{F}{0}:S3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:B1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K3{0,0}{F}{0}:B2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K4{0,0}{F}{0}:Q7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:S4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:R6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K3{0,0}{F}{0}:R7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K4{0,0}{F}{0}:S3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:B1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K3{0,0}{F}{0}:B2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K4{0,0}{F}{0}:Q7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:S4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:R6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K3{0,0}{F}{0}:R7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K4{0,0}{F}{0}:S3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// dashSpinupUp TODO: 100% confirm ; A2:C1,A2:B6,A2:C0,A2:S7,A2:T3,A2:T7,A2:T4,A2:T5,A2:T6,A2:B6,A2:C0,A2:S7,A2:T3,A2:T7,A2:T4,A2:T5,A2:T6,A2:B6,A2:C0,A2:S7,A2:T3,A2:T7,A2:T4,A2:T5
			"[dashSpinupUp]A2{0,0}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:B6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:C0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:S7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:B6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:C0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:S7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:B6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:C0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:S7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:T5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// dashSpinupDown TODO: 100% confirm ; A1:B3,A1:B4-M,A1:B5,A1:S5,A1:S6,A1:B4-M,A1:B5-M,A1:S5-M,A1:S6-M,A1:B4-M,A1:B5,A1:S5,A1:S6,A1:B4-M,A1:B5-M,A1:S5-M,A1:S6-M,A1:B4-M,A1:B5,A1:S5,A1:S6,A1:B4-M,A1:B5-M,A1:S5-M,A1:S6-M
			"[dashSpinupDown]A1{0,0}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:S5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:S6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:S5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:S6{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:S5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:S6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:S5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:S6{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:S5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:S6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:S5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:S6{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ",
			// salute TODO: 100% confirm ; A3:P4-M
			"[salute]A3{0,0}{F}{0}:P4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ",
			// itemGet TODO: 100% confirm ; L1:L2
			"[itemGet]L1{0,0}{F}{0}:L2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// triforceGet TODO: 100% confirm ; Z2:β4
			"[triforceGet]Z2{0,0}{F}{0}:β4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// readBook TODO: 100% confirm ; K5:K6
			"[readBook]K5{0,0}{F}{0}:K6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;",
			// prayer R1,A5:Q1,A5:Q0,S1
			"[prayer]R1{0,0}{F}{0}:S1{0,16}{T}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A5{0,1}{F}{0}:Q1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A5{0,1}{F}{0}:Q0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"S1{0,0}{B}{0}:T1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// fall TODO: 100% confirm ; G0,E5,E6,H4-T,H4-B,G4-B
			"[fall]G0{0,0}{B}{0}:G1{16,0}{BL}{0}:H0{0,8}{F}{0}:H1{16,8}{L}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"E5{0,0}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"E6{0,0}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"H4{0,0}{TR}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"H4{0,0}{BR}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"G4{0,0}{BR}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"G4{0,0}{E}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// grab TODO: 100% confirm ; A0:X2,Z3:Z4
			"[grab]A0{0,0}{F}{0}:X2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"Z3{0,0}{F}{0}:Z4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// grabUp TODO: 100% confirm ; Z0:V5,Y6
			"[grabUp]Z0{0,0}{F}{0}:V5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"Y6{0,0}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// grabDown TODO: 100% confirm ; E3:X5,U0:P7
			"[grabDown]E3{0,0}{F}{0}:X5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U0{0,0}{F}{0}:P7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// lift TODO: 100% confirm ; E2:U5,U1:U6,L6:O2
			"[lift]E2{0,0}{F}{0}:U5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U1{0,0}{F}{0}:U6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L6{0,0}{F}{0}:O2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// liftUp TODO: 100% confirm ; U2:U7,A2:V0,L7:O5
			"[liftUp]U2{0,0}{F}{0}:U7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:V0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L7{0,0}{F}{0}:O5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// liftDown TODO: 100% confirm ; U0:U4,U0:U3,L5:N7
			"[liftDown]U0{0,0}{F}{0}:U4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U0{0,0}{F}{0}:U3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L5{0,0}{F}{0}:N7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// carry TODO: 100% confirm ; L6:O2,L6:O3,L6:O4
			"[carry]L6{0,0}{F}{0}:O2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L6{0,0}{F}{0}:O3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L6{0,0}{F}{0}:O4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// carryUp TODO: 100% confirm ; L7:O5,L7:O6,L7:O7
			"[carryUp]L7{0,0}{F}{0}:O5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L7{0,0}{F}{0}:O6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L7{0,0}{F}{0}:O7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// carryDown TODO: 100% confirm ; L5:N7,L5:O0,L5:O1
			"[carryDown]L5{0,0}{F}{0}:N7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L5{0,0}{F}{0}:O0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L5{0,0}{F}{0}:O1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// treePull TODO: 100% confirm ; P7-UM:E7,N0:A1-UM,K2:K0,K1,F4,N0:A1-UM,K2:K0,K1
			"[treePull]P7{0,0}{F}{UM}:E7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"N0{0,0}{F}{0}:A1{0,8}{F}{UM}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K2{0,0}{F}{0}:K0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K1{0,0}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"F4{0,0}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"N0{0,0}{F}{0}:A1{0,8}{F}{UM}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K2{0,0}{F}{0}:K0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"K1{0,0}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// throw TODO: 100% confirm ; A0:M6,A0:B0
			"[throw]A0{0,0}{F}{0}:M6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// throwUp TODO: 100% confirm ; A2:M3,A2:C1
			"[throwUp]A2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// throwDown TODO: 100% confirm ; A1:M0,A1:B3
			"[throwDown]A1{0,0}{F}{0}:M0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// push TODO: 100% confirm ; U1:X2,U1:X3,U1:X4,U1:X2,U1:X3,U1:X2,U1:X3,U1:X4
			"[push]U1{0,0}{F}{0}:X2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U1{0,1}{F}{0}:X3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U1{0,2}{F}{0}:X4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U1{0,0}{F}{0}:X2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U1{0,1}{F}{0}:X3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U1{0,0}{F}{0}:X2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U1{0,1}{F}{0}:X3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U1{0,2}{F}{0}:X4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// pushUp TODO: 100% confirm ; U2:M3,U2:M4,U2:M5,U2:M3,U2:M4-M,U2:M3,U2:M4,U2:M5
			"[pushUp]U2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U2{0,1}{F}{0}:M4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U2{0,2}{F}{0}:M5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U2{0,1}{F}{0}:M4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U2{0,1}{F}{0}:M4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U2{0,2}{F}{0}:M5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// pushDown TODO: 100% confirm ; U0:X5,U0:X6,U0:X7,U0:X5,U0:X6-M,U0:X5,U0:X6,U0:X7
			"[pushDown]U0{0,3}{F}{0}:X5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U0{0,4}{F}{0}:X6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U0{0,5}{F}{0}:X7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U0{0,3}{F}{0}:X5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U0{0,4}{F}{0}:X6{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U0{0,3}{F}{0}:X5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U0{0,4}{F}{0}:X6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"U0{0,5}{F}{0}:X7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// shovel TODO: 100% confirm ; B7:D7,A0:F5,A0:C7
			"[shovel]B7{0,-1}{F}{0}:D7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:F5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{-1,0}{F}{0}:C7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// boomerang TODO: 100% confirm ; S2,A0:C4,A0:B0
			"[boomerang]S2{0,0}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:C4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// boomerangUp TODO: 100% confirm ; R2,A2:Q6,A2:C1
			"[boomerangUp]R2{0,0}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:Q6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// boomerangDown TODO: 100% confirm ; A1:Q5,A1:D0,A1:B3
			"[boomerangDown]A1{0,0}{F}{0}:Q5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:D0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// rod TODO: 100% confirm ; G2-R,A0:C4,A0:N4
			"[rod]G2{0,0}{BR}{0}:G3{8,0}{BL}{0}:H2{0,8}{R}{0}:H3{8,8}{L}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:N4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// rodUp TODO: 100% confirm ; G3-R,A2:D2,A2:N5
			"[rodUp]G1{0,0}{BR}{0}:G2{8,0}{BL}{0}:H1{0,8}{R}{0}:H2{8,8}{L}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:D2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:N5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// rodDown TODO: 100% confirm ; G1-R,A1:N6,A1:D0
			"[rodDown]G3{0,0}{BR}{0}:G4{8,0}{BL}{0}:H3{0,8}{R}{0}:H4{8,8}{L}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:N6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:D0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// powder TODO: 100% confirm ; A0:C2,A0:C3,A0:C4,A0:C5
			"[powder]A0{0,1}{F}{0}:C2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,1}{F}{0}:C3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,1}{F}{0}:C4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,1}{F}{0}:C5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// powderUp TODO: 100% confirm ; F1,A2:D1,A2:D2,A2:L4
			"[powderUp]F1{0,0}{F}{0}:G1{0,16}{T}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:D1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,-1}{F}{0}:D2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:L4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// powderDown TODO: 100% confirm ; F0,A1:C6,A3:D0,A3:L3
			"[powderDown]F0{0,0}{F}{0}:G0{0,16}{T}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,1}{F}{0}:C6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A3{0,1}{F}{0}:D0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A3{0,1}{F}{0}:L3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// cane TODO: 100% confirm ; A0:I2-M,L1:O2,A0:C4
			"[cane]A0{0,0}{F}{0}:I2{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"L1{0,0}{F}{0}:O2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:C4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// caneUp TODO: 100% confirm ; F1-M,A2:P5-M,A2:D2
			"[caneUp]F1{0,0}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:P5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:D2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// caneDown TODO: 100% confirm ; F0-M,A1:P4-M,A1:D0
			"[caneDown]F0{0,0}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:P4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:D0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bow TODO: 100% confirm ; A0:M6,A0:C4,A0:P6
			"[bow]A0{0,0}{F}{0}:M6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:C4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:P6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bowUp TODO: 100% confirm ; A2:C1,A2:M4,A2:P5
			"[bowUp]A2{0,0}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:M4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:P5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bowDown TODO: 100% confirm ; A1:B3,A1:B4,A1:B4
			"[bowDown]A1{0,0}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:B4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bombos TODO: 100% confirm ; A1:M0,A0-M:M6-M,A2:M3,A0:M6,A1:M0,A0-M:M6-M,A2:M3,A0:M6,A1:P3,A1:P4-M,A1:P3,A1:L3,A1:D0
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
				"A1{0,0}{F}{0}:L3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:D0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// ether TODO: 100% confirm ; A1:M0,A0-M:M6-M,A2:M3,A0:M6,A1:M0,A0-M:M6-M,A2:M3,A0:M6,A1:P3,A7:P4-M
			"[ether]A1{0,0}{F}{0}:M0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{M}:M6{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:M6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:M0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{M}:M6{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:M3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:M6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,0}{F}{0}:P3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A7{0,0}{F}{0}:P4{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ",
			// quake TODO: 100% confirm ; A1:M0,A0-M:M6-M,A2:M3,A0:M6,A1:M0,A0-M:M6-M,A2:M3,A0:M6,A1:P3,A1:P4-M,L5:N7,A1:Q1
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
				"A1{0,0}{F}{0}:Q1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// hookshot TODO: 100% confirm ; A0:C4
			"[hookshot]A0{0,0}{F}{0}:C4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// hookshotUp TODO: 100% confirm ; A2:D2
			"[hookshotUp]A2{0,0}{F}{0}:D2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// hookshotDown TODO: 100% confirm ; A1:D0
			"[hookshotDown]A1{0,0}{F}{0}:D0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// zap TODO: 100% confirm ; R0,S0
			"[zap]R0{0,0}{F}{0}:S0{0,16}{T}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"S0{0,0}{B}{0}:T0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bunnyStand TODO: 100% confirm ; α4:α5
			"[bunnyStand]α4{0,0}{F}{0}:α5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bunnyStandUp TODO: 100% confirm ; α1:α2
			"[bunnyStandUp]α1{0,0}{F}{0}:α2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bunnyStandDown TODO: 100% confirm ; Z5:α0
			"[bunnyStandDown]Z5{0,0}{F}{0}:α0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bunnyWalk TODO: 100% confirm ; α4:α5,α4:α6
			"[bunnyWalk]α4{0,0}{F}{0}:α5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"α4{0,0}{F}{0}:α6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bunnyWalkUp TODO: 100% confirm ; α1:α2,α1:α3
			"[bunnyWalkUp]α1{0,0}{F}{0}:α2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"α1{0,0}{F}{0}:α3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// bunnyWalkDown TODO: 100% confirm ; Z5:α0,Z5:Z7
			"[bunnyWalkDown]Z5{0,0}{F}{0}:α0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"Z5{0,1}{F}{0}:Z7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// walkUpstairs1F TODO: 100% confirm ; A2:V5,A2:V6,A2:C1,X1:Y3,X1:Y4,X1:Y5,X1:Y3,X1:Y4,X1:Y5,X1:Y3,X1:Y4,A0:V2,A0:B0,A0:V2,A0:B0,A0:V2,A0:B0,A0:V2,A0:B0
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
			// walkDownstairs1F TODO: 100% confirm ; A0-M:V2-M,A0-M:B0-M,A0-M:V1-M,B7-M:Y1-M,B7-M:Y2-M,B7-M:Y0-M,B7-M:Y1-M,B7-M:Y2-M,B7-M:Y0-M,B7-M:Y1-M,A1:V3,A1:V4,A1:B3,A1:V3-M,A1:V4-M,A1:B3,A1:V3,A1:V4,A1:B3,A1:V3-M,A1:S6,A1:B3
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
			// walkUpstairs2F TODO: 100% confirm ; A0:B0,A0:V1,B7:Y1,B7:Y2,B7:Y0,B7:Y1,B7:Y2,B7:Y0,B7:Y1,B7:Y2,A1:B3,A1:V3-M,A1:V4-M,A1:B3,A1:V3,A1:V4,A1:B3
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
			// walkDownstairs2F TODO: 100% confirm ; A2:C1,A2:V5,A2:V6,A2:C1,A2:D4,A2:M5-M,A2:C1,A2:V5,X1-M:Y4-M,X1-M:Y5-M,X1-M:Y3-M,X1-M:Y4-M,X1-M:Y5-M,X1-M:Y3-M,X1-M:Y4-M,X1-M:Y5-M,X1-M:Y3-M,A0-M:B0-M,A0-M:V1-M,A0-M:V2-M,A0-M:B0-M,A0-M:V1-M,A0-M:V2-M,A0-M:B0-M,A0-M:V1-M,A0-M:V2-M,A0-M:B0-M,A0-M:V1-M,A0-M:V2-M,A0-M:B0-M
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
			// deathSpin TODO: 100% confirm ; A1:B3,A0-M:B0-M,A2:C1,A0:B0,A1:B3,A0-M:B0-M,A2:C1,A0:B0,A1:B3,A0-M:B0-M,A2:C1,A0:B0,E2:J6,J7
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
				"J6{8,8}{R}{0}:J7{16,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// deathSplat TODO: 100% confirm ; E2:J6,J7
			"[deathSplat]E2{2,0}{F}{0}:J5{0,8}{R}{0}:J6{8,8}{L}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"J6{8,8}{R}{0}:J7{16,8}{F}{0} @ 3 ",
			// poke TODO: 100% confirm ; A0:N3,A0:N2,A0:F6
			"[poke]A0{0,0}{F}{0}:N3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:N2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{0,0}{F}{0}:F6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// pokeUp TODO: 100% confirm ; E4:D2,E4:F7,E4:L4
			"[pokeUp]E4{0,0}{F}{0}:D2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"E4{0,1}{F}{0}:F7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"E4{0,1}{F}{0}:L4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// pokeDown TODO: 100% confirm ; A1:N1,E3:G7
			"[pokeDown]A1{0,1}{F}{0}:N1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"E3{0,2}{F}{0}:G7{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// tallGrass TODO: 100% confirm ; A0:B0,A0:V1,A0:V2
			"[tallGrass]A0{-1,0}{F}{0}:B0{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{-1,1}{F}{0}:V1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A0{-1,2}{F}{0}:V2{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// tallGrassUp TODO: 100% confirm ; A2:V5,A2:V6,A2:C1,A2:D4,A2:M5-M
			"[tallGrassUp]A2{0,1}{F}{0}:V5{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,2}{F}{0}:V6{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,0}{F}{0}:C1{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,1}{F}{0}:D4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A2{0,2}{F}{0}:M5{0,8}{F}{M}:SHADOW0{0,8}{F}{0} @ 3 ",
			// tallGrassDown TODO: 100% confirm ; A1:B3,A1:V3,A1:V4
			"[tallGrassDown]A1{0,0}{F}{0}:B3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,1}{F}{0}:V3{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ;" +
				"A1{0,2}{F}{0}:V4{0,8}{F}{0}:SHADOW0{0,8}{F}{0} @ 3 ",
			// mapDungeon TODO: 100% confirm ; K7
			"[mapDungeon]K7{0,0}{F}{0} @ 3 ",
			// mapWorld TODO: 100% confirm ; Y7
			"[mapWorld]Y7{0,0}{F}{0};Y7{0,0}{E}{0} @ 3 ",
			// sleep TODO: 100% confirm ; A6:D3
			"[sleep]A6{0,0}{F}{0}:D3{0,5}{F}{0} @ 3 ",
			// awake TODO: 100% confirm ; E3:D3
			"[awake]E3{0,0}{F}{0}:D3{0,7}{F}{0} @ 3 "
		};
}