<%-- 
    Document   : Edit-product
    Created on : Jun 22, 2022, 9:25:43 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Edit Product - Dashboard Admin Template</title>
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
            />
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="/Assignment/Views/jquery-ui-datepicker/jquery-ui.min.css" type="text/css" />
        <!-- http://api.jqueryui.com/datepicker/ -->
        <link rel="stylesheet" href="/Assignment/Views/css/bootstrap.min.2.css" />
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="/Assignment/Views/css/templatemo-style.css">
        <!--
            Product Admin CSS Template
            https://templatemo.com/tm-524-product-admin
        -->
    </head>

    <body>
        <jsp:include page="../ManagerHeader.jsp" flush="true" />
        <div class="container tm-mt-big tm-mb-big">
            <div class="row">
                <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                    <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                        <div class="row">
                            <div class="col-12">
                                <h2 class="tm-block-title d-inline-block">Edit Product</h2>
                            </div>
                        </div>
                        <form 
                            action="ModifyItem" 
                            method="post" 
                            class="tm-edit-product-form"
                            >
                            <div class="row tm-edit-product-row">
                                <div class="col-xl-6 col-lg-6 col-md-12">
                                    <input name="updatedItem_id" value="${updatedItem.item_id}" hidden>
                                    <div class="form-group mb-3">
                                        <label for="name">Product Name</label>
                                        <input
                                            id="name"
                                            name="item_name"
                                            type="text"
                                            value="${updatedItem.item_name}"
                                            class="form-control validate"
                                            required
                                            />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="name">Product Price</label>
                                        <input
                                            id="name"
                                            name="item_price"
                                            type="text"
                                            value="${updatedItem.item_price}"
                                            class="form-control validate"
                                            required
                                            />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="name">Product Quantity</label>
                                        <input
                                            id="name"
                                            name="item_quantity"
                                            type="text"
                                            value="${updatedItem.item_quantity}"
                                            class="form-control validate"
                                            required
                                            />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="description">Description</label>
                                        <textarea                    
                                            class="form-control validate tm-small"
                                            rows="10"
                                            name="item_description"                                       
                                            >${updatedItem.item_description}</textarea>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="category">Category</label>
                                        <select
                                            class="custom-select tm-select-accounts"
                                            id="category"
                                            name="tag_id"
                                            >
                                            <option disabled="">Select category</option>
                                            <c:forEach items="${tag_list}" var="tag">
                                                <c:choose>
                                                    <c:when test="${updatedItem.tag_name == tag.value}">
                                                        <option value="${tag.key}" selected>${tag.value}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${tag.key}">${tag.value}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </div>      
                                    <div class="form-group mb-3">
                                        <label for="name">Discount</label>
                                        <input
                                            id="discount"
                                            name="discount"
                                            type="number"
                                            value="${updatedItem.discount}"
                                            class="form-control validate"
                                            />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="name">Username</label>
                                        <input
                                            id="username"
                                            name="username"
                                            type="text"
                                            class="form-control validate"
                                            value="${acc.username}"
                                            disabled
                                            style="color: black;"
                                            />
                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
                                    <c:choose>
                                        <c:when test="${isUpdate == true}">
                                            <div class="tm-product-img-edit mx-auto"> 
                                                <img 
                                                    src="${updatedItem.item_img}" 
                                                    alt="Product image" 
                                                    class="img-fluid d-block mx-auto"
                                                    style="height: 100px; width: 100px;"
                                                    id="img-product"
                                                    >
                                            </div>
                                            <div class="custom-file mt-3 mb-3">
                                                <input 
                                                    type="file" 
                                                    name="item_img"
                                                    class="btn btn-primary btn-block mx-auto file-upload"
                                                    data-img="img-product" 
                                                    data-max-size="5242880" 
                                                    data-error-max-size="File không quá 5MB" 
                                                    data-max-width="256" 
                                                    data-max-height="256"
                                                    value="${updatedItem.item_img}"
                                                    />
                                                <input type="hidden" name="img-product" value="${updatedItem.item_img}"> 
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="tm-product-img-edit mx-auto"> 
                                                <img 
                                                    src="${updatedItem.item_img}" 
                                                    alt="Product image" 
                                                    class="img-fluid d-block mx-auto"
                                                    style="height: 100px; width: 100px;"
                                                    id="img-product"
                                                    >
                                            </div>
                                            <div class="form-group mb-3">
                                                <label for="name">Image</label>
                                                <input 
                                                    type="file" 
                                                    name="item_img"
                                                    class="btn btn-primary btn-block mx-auto file-upload"
                                                    data-img="img-product" 
                                                    data-max-size="5242880" 
                                                    data-error-max-size="File không quá 5MB" 
                                                    data-max-width="256" 
                                                    data-max-height="256"
                                                    value="${updatedItem.item_img}"
                                                    />
                                                <input type="hidden" name="img-product" value="${updatedItem.item_img}">
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="col-12">
                                    <c:choose>
                                        <c:when test="${isUpdate == true}">
                                            <button 
                                                type="submit" 
                                                class="btn btn-primary btn-block text-uppercase" 
                                                name="update" 
                                                value="update"
                                                >Update Now</button>
                                        </c:when>
                                        <c:otherwise>
                                            <button 
                                                type="submit" 
                                                class="btn btn-primary btn-block text-uppercase" 
                                                name="insert" 
                                                value="insert"
                                                >Insert Now</button>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </form>                
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="../ManagerFooter.jsp" flush="true" />
        <script src="/Assignment/Views/js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="/Assignment/Views/jquery-ui-datepicker/jquery-ui.min.js"></script>
        <!-- https://jqueryui.com/download/ -->
        <script src="/Assignment/Views/js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script src="/Assignment/Views/js/FileUpLoad.js"></script>

        <script>

        </script>
    </body>
</html>
>
