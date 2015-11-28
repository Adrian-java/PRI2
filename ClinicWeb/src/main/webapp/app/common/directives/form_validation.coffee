angular.module 'clinic'
  .directive 'formValidation', [ ->
    restrict: 'A'
    link: (scope, elem, attrs) ->
      $(elem).submit((e) ->
        fields = $(this).find('input, select')
        $(fields).each( ->
          if(!$(this).val())
            $(this).parent().parent().addClass('has-error')
            $(this).focus()
            $('.has-error').on('keypress', ->
              $(this).removeClass('has-error')
            )
            return false
        )
        return true
      )
  ]
