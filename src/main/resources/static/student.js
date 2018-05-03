 function postData() {
            console.log("posting data...");

            // Get values from html.
            var name = $("#inputName").val();
            var year = $("#inputYear").val();

            // Create JS object with data.
            var newStudent = {
                name : name,
                year : year
            };
            console.log(newStudent);

            // Convert JS object to JSON.
            var validJsonBook = JSON.stringify(newStudent);
            console.log(validJson);

            // Post JSON to endpoint.
            $.ajax({
                url:"http://localhost:8080/",
                type:"post",
                data: validJsonStudent,
                contentType: "application/json",
                success: function(result) {
                    // On successful post, reload data to get the added one as well.
                    console.log("success post data!");
                    getData();
                }
            });
        }

        function getData() {
            console.log("getting data...");

            // Get the data from endpoint.
            $.ajax({
                url:"http://localhost:8080/api/all",
                type:"get",
                success: function(students) {
                    // On successful get, reload the datatable with new data.
                    console.log("This is the data: " + students);
                    $('#table').DataTable().clear();
                    $('#table').DataTable().rows.add(students);
                    $('#table').DataTable().columns.adjust().draw();
                }
            });
        }



        $(document).ready(function () {


            // Load DataTable with data format.
            $('#table').DataTable({
                columns: [
                    { "data": "id" },
                    { "data": "name" },
                    { "data": "year" }
                ]
            });

            // Load first data.
            getData();
        });


  $("#saveForm").submit(postData);
