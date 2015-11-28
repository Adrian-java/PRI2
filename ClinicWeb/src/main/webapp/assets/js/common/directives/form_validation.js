(function() {
  angular.module('clinic').directive('formValidation', [
    function() {
      return {
        restrict: 'A',
        link: function(scope, elem, attrs) {
          return $(elem).submit(function(e) {
            var fields;
            fields = $(this).find('input, select');
            $(fields).each(function() {
              if (!$(this).val()) {
                $(this).parent().parent().addClass('has-error');
                $(this).focus();
                $('.has-error').on('keypress', function() {
                  return $(this).removeClass('has-error');
                });
                return false;
              }
            });
            return true;
          });
        }
      };
    }
  ]);

}).call(this);
