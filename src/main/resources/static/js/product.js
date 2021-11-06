getAll();
let page = 0;


function getAll() {
    $.ajax({
        url: `http://localhost:8080/products`,
        type: "GET",
        success: function (product) {
            if (product.content.length === 0) {
                $("#list").html(
                    `<tr>
                        <th colspan=6 style="color: red ; text-align: center">Không có dữ liệu</th>
                    </tr>`
                )
            } else {
                let ct = ""
                for (let i = 0; i < product.content.length; i++) {
                    ct += getProduct(product.content[i])
                }
                $("#list").html(ct);
            }
        }
    })
}

function getProduct(product) {
    return ` <tr>
                <th scope="row">${product.id}</th>
                <td>${product.name}</td>
                <td>${product.code}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.amount}</td>
                <td>${product.category?.name}</td>
                <td>${product.brand?.name}</td>
                <td>${product.discount}</td>
                <td><button type="button" class="btn btn-warning" onclick="showUpdateProduct(${product.id})">Edit</button></td>
                <td><button type="button" class="btn btn-primary"   onclick="showDeleteProduct(${product.id})">Delete</button></td>
            </tr>`
}

function clear() {
    $("#nameProductCreate").val("")
    $("#codeProductCreate").val("")
    $("#descriptionProductCreate").val("")
    $("#priceProductCreate").val("")
    $("#amountProductCreate").val("")
    $("#categoryProductCreate").val("")
    $("#brandProductCreate").val("")
    $("#discountProductCreate").val("")
}

function createProduct() {
    let name = $("#nameProductCreate").val();
    let code = $("#codeProductCreate").val();
    let description = $("#descriptionProductCreate").val();
    let price = $("#priceProductCreate").val();
    let amount = $("#amountProductCreate").val();
    let category = $("#categoryProductCreate").val();
    let brand = $("#brandProductCreate").val();
    let discount = $("#discountProductCreate").val();
    let newProduct = {
        name: name,
        code: code,
        description: description,
        price: price,
        amount: amount,
        category: {
            id: category
        },
        brand: {
            id: brand
        },
        discount: discount,
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        url: `http://localhost:8080/products`,
        type: "POST",
        data: JSON.stringify(newProduct),
        success: function () {
            getAll();
            clear();
        }
    }).fail(function (e){
        console.log(e)
    })
}

function showUpdateProduct(id) {
    let myModal = new bootstrap.Modal(document.getElementById('editingModal'));
    myModal.show();
    $.ajax({
        url: `http://localhost:8080/products/${id}`,
        type: "GET",
        success: function (product) {
            $("#idEditProduct").val(product.id)
            $("#nameEditProduct").val(product.name)
            $("#codeEditProduct").val(product.code)
            $("#descriptionEditProduct").val(product.description)
            $("#priceEditProduct").val(product.price)
            $("#amountEditProduct").val(product.amount)
            $("#categoryEditProduct").val(product.category.id)
            $("#brandEditProduct").val(product.brand.id)
            $("#discountEditProduct").val(product.discount)
            $('#editProductInfo').click(function () {updateProduct(id)});
        }
    })
}

function updateProduct() {
    let id = $("#idEditProduct").val();
    let name = $("#nameEditProduct").val();
    let code = $("#codeEditProduct").val();
    let description = $("#descriptionEditProduct").val();
    let price = $("#priceEditProduct").val();
    let amount = $("#amountEditProduct").val();
    let category = $("#categoryEditProduct").val();
    let brand = $("#brandEditProduct").val();
    let discount = $("#discountEditProduct").val();
    let productUpdate = {
        id: id,
        name: name,
        code: code,
        description: description,
        price: price,
        amount: amount,
        category: {
            id: category
        },
        brand: {
            id: brand
        },
        discount: discount
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: `http://localhost:8080/products/${id}`,
        type: "PUT",
        data: JSON.stringify(productUpdate),
        success: function () {
            getAll();
        }
    })
}

function showDeleteProduct(id) {
    let myModal = new bootstrap.Modal(document.getElementById('deleteModal'));
    myModal.show();
    $.ajax({
        url:  `http://localhost:8080/products/${id}`,
        type: "GET",
        success: function (product) {
            $("#nameDeleteProduct").html(product.name)
            $("#codeDeleteProduct").html(product.code)
            $("#descriptionDeleteProduct").html(product.description)
            $("#priceDeleteProduct").html(product.price)
            $("#amountDeleteProduct").html(product.amount)
            $("#categoryDeleteProduct").html(product.category)
            $("#brandDeleteProduct").html(product.brand)
            $("#discountDeleteProduct").html(product.discount)
            $("#deleteProductInfo").click(function () {
                removeProduct(id)
            })
            }
    })
}

function removeProduct(id) {
    $.ajax({
        url: `http://localhost:8080/products/${id}`,
        type: "DELETE",
        success : function () {
            getAll();
        }
    })
}

function nextPage() {
    page++;

    $.ajax({
        type: "GET",
        url: `http://localhost:8080/products?page=${page}`,
        success: function (product) {
                let ct = ""
                for (let i = 0; i < product.content.length; i++) {
                    ct += getProduct(product.content[i])
                }
                $("#list").html(ct);
        }
    })
}

function prePage() {
    if (page > 0) {
        page--;
    }
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/products?page=${page}`,
        success: function (product) {
                let ct = ""
                for (let i = 0; i < product.content.length; i++) {
                    ct += getProduct(product.content[i])
                }
                $("#list").html(ct);
        }
    })
}

function searchProductByName() {
    let search = $('#q').val();
    $.ajax({
        type: `GET`,
        url: `http://localhost:8080/products?q=${search}`,
        success: function (product) {
            let ct = ""
            for (let i = 0; i < product.content.length; i++) {
                ct += getProduct(product.content[i])
            }
            $("#list").html(ct);
        }
    })
}

$(document).ready(function (){
    $.ajax({
        type: "GET",
        url: `https://provinces.open-api.vn/api/`,
        success: function (province) {
            console.log(province)
        }
    })
})