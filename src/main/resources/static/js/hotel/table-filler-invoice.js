$(document).ready(function () {
    var table = $("#myTable").DataTable();
    $.ajax({
        url: "/api/invoice/all",
        type: "get",
        success: function (result) {
            $("#myTableBody").html("");
            $.each(result, function (index, invoice) {
                var totalAmountBills = 0;
                for (var i = 0; i < invoice.invoiceLines.length; i++) {
                    totalAmountBills += invoice.invoiceLines[i].invoiceLineCost;
                }
                table.row
                    .add([
                        invoice.createdDate,
                        invoice.origin,
                        totalAmountBills,
                        invoice.paid
                    ])
                    .draw(false);
            });
        }

    });
    $('#myTable #myTableBody').on('click', 'tr', function () {
        var data = table.row(this).data();
        alert('Deze invoice is gemaakt in het ' + data[1]);
    });
});