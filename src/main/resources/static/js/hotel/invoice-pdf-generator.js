$(document).ready(function() {
    var table = $("#myTable").DataTable();
    $.ajax({
        url: "/api/invoice/all",
        type: "get",
        success: function(result) {
            $("#myTableBody").html("");
            $.each(result, function(index, invoice) {
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


    var doc = new jsPDF({
        orientation: 'portrait',
        unit: 'in',
        format: [14, 8]
    })


//    doc.addFont('Arial', 'normal', 'sans-serif');
//    doc.setFont('Arial');

    doc.setFontSize(12);
    doc.text('                                                          INVOICE', 1, 1)
    doc.text('', 1, 1)
    doc.text('ik ben hier', 1, 1)

    $("#pdfobject").attr("src", doc.output("datauri"));




   // doc.save('two-by-four.pdf')
});
