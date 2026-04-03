//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    println("===== SISTEM PENILAIAN =====\n")

    print("Masukkan Nama Mahasiswa: ")
    val nama = readLine()!!

    print("Masukkan Nilai UTS (0-100): ")
    val uts = readLine()!!.toInt()

    print("Masukkan Nilai UAS (0-100): ")
    val uas = readLine()!!.toInt()

    print("Masukkan Nilai Tugas (0-100): ")
    val tugas = readLine()!!.toInt()

    // Validasi input
    if (uts !in 0..100 || uas !in 0..100 || tugas !in 0..100) {
        println("\nNilai harus berada dalam rentang 0 - 100")
        return
    }

    // Menghitung nilai akhir
    val nilaiAkhir = (uts * 0.3) + (uas * 0.4) + (tugas * 0.3)

    // Konversi nilai menggunakan when
    val grade = when (nilaiAkhir.toInt()) {
        in 85..100 -> "A"
        in 70..84 -> "B"
        in 60..69 -> "C"
        in 50..59 -> "D"
        else -> "E"
    }

    // Keterangan berdasarkan grade
    val keterangan = when (grade) {
        "A" -> "Sangat Baik"
        "B" -> "Baik"
        "C" -> "Cukup"
        "D" -> "Kurang"
        else -> "Sangat Kurang"
    }

    // Status kelulusan
    val status = if (nilaiAkhir >= 60) "LULUS" else "TIDAK LULUS"

    println("\n===== HASIL PENILAIAN =====")
    println("Nama        : $nama")
    println("Nilai UTS   : $uts (Bobot 30%)")
    println("Nilai UAS   : $uas (Bobot 40%)")
    println("Nilai Tugas : $tugas (Bobot 30%)")
    println("-----------------------------")
    println("Nilai Akhir : $nilaiAkhir")
    println("Grade       : $grade")
    println("Keterangan  : $keterangan")
    println("Status      : $status")

    if (status == "LULUS") {
        println("\nSelamat! Anda dinyatakan LULUS.")
    } else {
        println("\nMaaf, Anda dinyatakan TIDAK LULUS.")
    }
}
