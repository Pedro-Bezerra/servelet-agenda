/**
 * Validação de formulários
 */

function validar() {
	const nome = fromContato.nome.value;
	const telefone = fromContato.telefone.value;
	
	if (!nome) {
		alert("Preencha o campo nome");
		fromContato.nome.focus;
		return false;
	} else if (!telefone) {
		alert("Preecha o campo telefone");
		fromContato.telefone.focus;
		return false;
	} else {
		document.forms["fromContato"].submit();
	}
}