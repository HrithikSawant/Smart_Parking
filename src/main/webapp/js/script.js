console.log("#payment_field");
const paymentStart = () => {
    console.log("paymentStarted");
    let amount = $("#payment_field").val();
    console.log(amount);
    if (amount == '' || amount == null)
    {
        alert("amout is required");
        return;
    }

    //code...
    //we will use ajax to send request to server to create order -jquery
    $.ajax(
            {
                url: 'pay',
                data :{amount: amount},
                contentType: 'application/json',
                type: 'POST',
                dataType: 'json',
                success: function (response) {
                    //invoked when success
                    console.log(response);
                },
                error: function (error) {
                    //invoked when error
                    console.log(error);
                    alert("something went wrong !!");
                }
            }
    );
};