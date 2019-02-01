class Utils {
    
    constructor() {
        
        throw new Error('Esta classe não pode ser instanciada');
    }
    
    static decimalToFormatMoney(valor) {
    	  let val = valor.toString();
    	  //let valor = document.getElementById("in").value;
    	  let contemPonto = val.indexOf('.');
    	  
    	  if(contemPonto > 0){
    	    let valores = val.split('.');
    	    if(valores[1].length < 2){
    	    	valores[1] += '0';
    	    }
    	    val = 'R$ ' + valores[0] + ',' + valores[1];
    	  }else{
    	    val = 'R$ ' + val + ',00'
    	  }
    	  
    	 
    	  
    	  return val;
    	}
}