enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String) {

    val numMatricula = { (1000..10000).random().toString() }

    override fun toString(): String {
        return "$nome"
    }

}

data class ConteudoEducacional(var nome: String, val duracao: Int) {
    override fun toString(): String {
        return "Nome Curso: $nome Duração: $duracao"
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
    val inscritos = mutableListOf<Usuario>()

    fun inscrever(vararg usuario: Usuario) {
        inscritos.addAll(usuario)
    }

    override fun toString(): String {
        return "Formação: ${nome}\nConteudo Educacional: ${conteudos}\nNivel: ${nivel}\nInscritos: ${inscritos}"

    }
}

fun main() {
    val leandro = Usuario("Leandro")
    val paulo = Usuario("Paulo")
    val ana = Usuario("Ana")
    val gustavo = Usuario("Gustavo")
    val samy = Usuario("Samy")
    val manu = Usuario("Manu")

    val conteudoEducacionalJava = ConteudoEducacional("Java", 150)
    val conteudoEducacionalKotlin = ConteudoEducacional("Kotlin", 120)
    val conteudoEducacionalSpring = ConteudoEducacional("Spring Framework", 100)

    val formacaoJava = Formacao("Java Developer", listOf(conteudoEducacionalJava), Nivel.INTERMEDIARIO)
    val formacaoKotlin = Formacao("Formação Kotlin Developer", listOf(conteudoEducacionalKotlin), Nivel.BASICO)
    val formacaoSpring = Formacao("Spring Framework Developer", listOf(conteudoEducacionalSpring), Nivel.AVANCADO)

    formacaoJava.inscrever(leandro,ana)
    formacaoKotlin.inscrever(paulo,gustavo)
    formacaoSpring.inscrever(samy,manu)


    println("$formacaoKotlin \n")
    println("$formacaoJava \n")
    println("$formacaoSpring \n")

}
