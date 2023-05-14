package com.ptit.csdlpt;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChuyenBay {
	private String maCB, maMB, sanBayXuatPhat, sanBayDich;
	private Timestamp thoiGianBatDau, thoiGianKetThuc;
	private int slChoNgoiConLai;
}
