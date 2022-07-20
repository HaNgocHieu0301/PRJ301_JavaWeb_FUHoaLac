/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function Validator(options) {
    var formElement = document.querySelector(options.form);
    if (formElement) {
        options.rules.forEach(function (rule){
            var inputElement = formElement.querySelector(rule.selector);
            
            if(inputElement){
                inputElement.onblur = function(){
                    
                }
            }
        })
    }

}
Validator.isRequired = function (selector) {
    return{
        selector: selector,
        test: function () {

        }
    };
}

Validator.isEmail = function (selector) {
    return{
        selector: selector,
        test: function () {

        }
    };
}

