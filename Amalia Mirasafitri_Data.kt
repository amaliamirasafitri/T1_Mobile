data class NilaiMahasiswa(
    val nim: String,
    val nama: String,
    val matakuliah: String,
    val nilai: Int
)

fun getGrade(nilai: Int): String {
    return when (nilai) {
        in 85..100 -> "A"
        in 70..84  -> "B"
        in 60..69  -> "C"
        in 50..59  -> "D"
        else -> "E"
    }
}

fun main() {
    val mahasiswa = listOf(
        NilaiMahasiswa("2023002",  "Amalia Mirasafitri", "Pemrograman", 85),
        NilaiMahasiswa("20230017", "Ceisya",             "Pemrograman", 80),
        NilaiMahasiswa("20230022", "Khenzy",             "Pemrograman", 85),
        NilaiMahasiswa("20230010", "Rizkiatul",          "Pemrograman", 60),
        NilaiMahasiswa("20230031", "Ardelia",            "Pemrograman", 70),
        NilaiMahasiswa("2023002",  "Kamilia",            "Pemrograman", 85),
        NilaiMahasiswa("20230017", "Intan",              "Pemrograman", 80),
        NilaiMahasiswa("20230022", "Salsa",              "Pemrograman", 85),
        NilaiMahasiswa("20230010", "Wiwik",              "Pemrograman", 60),
        NilaiMahasiswa("20230031", "Maulida",            "Pemrograman", 70)
    )

    println("===== DATA NILAI MAHASISWA =====\n")
    println(String.format("%-3s %-10s %-20s %-15s %-5s", "No", "NIM", "Nama", "MataKuliah", "Nilai"))
    mahasiswa.forEachIndexed { index, m ->
        println(String.format("%-3d %-10s %-20s %-15s %-5d",
            index + 1,
            m.nim,
            m.nama,
            m.matakuliah,
            m.nilai
        ))
    }

    // Filter lulus
    val lulus = mahasiswa.filter { it.nilai >= 70 }

    // Filter tidak lulus
    val tidakLulus = mahasiswa.filter { it.nilai < 70 }

    // Rata rata
    val rataRata = mahasiswa.map { it.nilai }.average()

    // Nilai tertinggi
    val tertinggi = mahasiswa.maxByOrNull { it.nilai }

    // Nilai terendah
    val terendah = mahasiswa.minByOrNull { it.nilai }

    println("\n===== STATISTIK =====")
    println("Total Mahasiswa : ${mahasiswa.size}")
    println("Rata-rata Nilai : $rataRata")
    println("Nilai Tertinggi : ${tertinggi?.nilai} (${tertinggi?.nama})")
    println("Nilai Terendah  : ${terendah?.nilai} (${terendah?.nama})")

    println("\n===== MAHASISWA LULUS =====")
    lulus.forEachIndexed { index, m ->
        println("${index + 1}. ${m.nama} - ${m.nilai} (${getGrade(m.nilai)})")
    }

    println("\n===== MAHASISWA TIDAK LULUS =====")
    tidakLulus.forEachIndexed { index, m ->
        println("${index + 1}. ${m.nama} - ${m.nilai} (${getGrade(m.nilai)})")
    }

    // Urut ascending
    val ascending = mahasiswa.sortedBy { it.nilai }

    // Urut descending
    val descending = mahasiswa.sortedByDescending { it.nilai }

    // Group by grade
    val groupGrade = mahasiswa.groupBy { getGrade(it.nilai) }

    println("\n===== JUMLAH PER GRADE =====")
    groupGrade.forEach { (grade, list) ->
        println("Grade $grade : ${list.size} mahasiswa")
    }

    // Cari nama
    val cari = mahasiswa.filter { it.nama.contains("Ani", ignoreCase = true) }
    println("\n===== HASIL PENCARIAN NAMA =====")
    cari.forEach {
        println("${it.nama} - ${it.nilai}")
    }
}
