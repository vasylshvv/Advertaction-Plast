$(document).ready(function() {
  $('#filters').on('submit', filtersItem);
  $('#search-events').on('keyup', filtersItem);

  function filtersItem(e) {
    e.preventDefault();
    const type = $('#selecttype').val(),
      level = $('#selectlevel').val(),
      month = $('#selectmonth').val(),
      items = $('#mytable tbody tr'),
      search = $('#search-events').val().toLowerCase();
    const re = new RegExp(search);

    $(items).hide();
    if (type === '0' && level === '0' && month === '0' && !search.length) {
      $(items).show();
    }
    $('#mytable tbody .no-results').hide();

    $(items).each(function() {
      let arr = [];
      if (type === '0') arr.push(true);
      else if (type !== '0' && $(this).attr('data-type') === type) arr.push(true);
      if (level === '0') arr.push(true);
      else if (level !== '0' && $(this).attr('data-level') === level) arr.push(true);
      if (month === '0') arr.push(true);
      else if (month !== '0' && ($(this).attr('data-from') === month || $(this).attr('data-to') === month)) arr.push(true);
      if (!search.length) arr.push(true);
      else if (re.test($(this).find('.event-name').text().toLowerCase())) arr.push(true);
      if (arr.length === 4) $(this).show();
    });

    if (!$('#mytable tbody tr:visible').length) {
      $('#mytable tbody .no-results').show();
    }
  }
});