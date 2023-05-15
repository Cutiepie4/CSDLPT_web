package com.ptit.csdlpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThongKe {
	private String tenCN, diaChi;
	private int tongSoVe, tongTienBanVe;
}
