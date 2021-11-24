<%@page import="com.mycompany.smartparkingmanagement.entities.Slot"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error_page.jsp" %>
<%
    ArrayList<Slot> slot = (ArrayList<Slot>) request.getAttribute("slot");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ include file="components/bootstrap.jsp"%>
    </head>
    <style> 
        .example {
            background-color: #eee;
            overflow-y: scroll; /* Add the ability to scroll */
        }

        /* Hide scrollbar for Chrome, Safari and Opera */
        .example::-webkit-scrollbar {
            display: none;
        }

        /* Hide scrollbar for IE, Edge and Firefox */
        .example {
            -ms-overflow-style: none;  /* IE and Edge */
            scrollbar-width: none;  /* Firefox */
        }
    </style>
    <body class="example">

        <%@ include file="components/message.jsp"%>
        <div class="row">
            <!-- ADD SLOT  Card-->
            <div class="col-lg-4 mt-5">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title my-2">Add new Slots</h4>
                        <a data-bs-toggle="modal"  data-bs-target="#AddSlotModal" class="btn btn-dark mt-5">Add Slot</a>
                    </div>
                </div>
            </div>
            <!-- ADD SLOT  Card-->
            <div class="col-lg-4 mt-5">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title my-2">Update a Slots</h4>
                        <a data-bs-toggle="modal"  data-bs-target="#UpdateSlotModal" class="btn btn-dark mt-5">Update Slot</a>
                    </div>
                </div>
            </div>
            <!-- Remove SLOT  Card-->
            <div class="col-lg-4 mt-5">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title my-2">Remove a Slot</h4>
                        <a data-bs-toggle="modal"  data-bs-target="#RemoveSlotModal" class="btn btn-dark mt-5">Remove Slot</a>
                    </div>
                </div>
            </div>

            <%-- Search stuffs Card --%>
            <div class="col-lg-4 mt-5">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title my-2">Search Buffer Slots</h4>
                        <a data-bs-toggle="modal"  data-bs-target="#SearchBufferModal" class="btn btn-dark mt-5">Search Slots</a>
                    </div>
                </div>
            </div>        
        </div>

        <%                if (slot != null) {
                if (slot.size() > 0) {
        %>
        <div>
            <table class="table table-sm">
                <thead>
                    <tr>
                        <th scope="col">Slot ID</th>
                        <th scope="col">Block ID</th>
                    </tr>
                </thead>
                <tbody>
                    <%  for (Slot s : slot) {%>
                    <tr>
                        <td><%= s.getSlot_id()%></td>
                        <td><%= s.getBlock_id()%></td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                <div>No Record Found</div>

                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
        <!-------------------------ADD NEW SLOT MODAL------------------------------>
        <div class="modal fade"  id="AddSlotModal" aria-hidden="true" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">ADD New SLot</h5>
                        <!--                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>-->
                    </div>
                    <div class="modal-body">
                        <p class="card-text">Slot id will be created automatically</p>
                        <!-- ADD SLOT -->
                        <form name="SlotAdd" action="AdminPanel" method="POST">
                            <div class="form-group row align-items-center">
                                <div class="form-group col-4 ms-5 mt-3">  
                                    <h4 class="label"><b>Block ID :</b></h4>  
                                </div>
                                <div class="form-group ms-2 col-6 mt-3">                                                     
                                    <input class="form-control" placeholder="Block ID :" type="text" name="block_id" value="" />
                                </div>
                                <div class="form-group col-4 ms-5 mt-3">  
                                    <h4 class="label"><b>Status  :</b></h4>  
                                </div>
                                <div class="col-3 mt-3 ms-2">
                                    <input class="form-check-input" type="radio" name="status" value="green" checked="checked" />
                                    <label class="form-check-label">Green</label>
                                </div>
                                <div class="col-3 mt-3">
                                    <input class="form-check-input" type="radio" name="status" value="red" />                                
                                    <label class="form-check-label">Red</label>
                                </div>
                                <div class="form-group col-4 ms-5 mt-3">  
                                    <h4 class="label"><b>Buffer:</b></h4>
                                </div>
                                <div class="col-3 mt-3 ms-2">
                                    <input class="form-check-input"  type="radio" name="buffer" value="no" checked="checked" />                      
                                    <label class="form-check-label">No</label>
                                </div>
                                <div class="col-3 mt-3">
                                    <input class="form-check-input" type="radio" name="buffer" value="yes" />                                                                
                                    <label class="form-check-label">Yes</label>
                                </div> 
                                <div class="form-group d-flex justify-content-center">
                                    <input type="hidden" name="val" value="slotadd" />
                                    <button type="submit" class="btn btn-primary col-5 col-sm-3 mt-4">Add Slot</button>                     
                                    <button type="button" class="btn btn-dark col-5 col-sm-3 mt-4 ms-2" data-bs-dismiss="modal">Cancel</button>         
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!----------------------///////ADD NEW SLOT MODAL//////////-------------------------->

        <!--------------------------------UPDATE SLOT--------------------------------------->
        <div class="modal fade"  id="UpdateSlotModal" aria-hidden="true" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Update a SLot</h5>                       
                        <!--<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>-->
                    </div>
                    <div class="modal-body">
                        <!-- Update SLOT -->
                        <form name="SlotUpdate" action="AdminPanel" method="POST">

                            <div class="form-group row align-items-center">
                                <div class="form-group col-4 ms-5 mt-3">  
                                    <h4 class="label"><b>Slot ID :</b></h4>  
                                </div>
                                <div class="form-group ms-2 col-6 mt-3"> 
                                    <input class="form-control" type="text" name="slot_id" value="" />
                                </div>
                                <div class="form-group col-4 ms-5 mt-3">  
                                    <h4 class="label"><b>Block ID :</b></h4>  
                                </div>
                                <div class="form-group ms-2 col-6 mt-3">                                                     
                                    <input class="form-control" placeholder="Block ID :" type="text" name="block_id" value="" />
                                </div>
                                <div class="form-group col-4 ms-5 mt-3">  
                                    <h4 class="label"><b>Status  :</b></h4>  
                                </div>
                                <div class="col-3 mt-3 ms-2">
                                    <input class="form-check-input" type="radio" name="status" value="green" checked="checked" />
                                    <label class="form-check-label">Green</label>
                                </div>
                                <div class="col-3 mt-3">
                                    <input class="form-check-input" type="radio" name="status" value="red" />                                
                                    <label class="form-check-label">Red</label>
                                </div>
                                <div class="form-group col-4 ms-5 mt-3">  
                                    <h4 class="label"><b>Buffer:</b></h4>
                                </div>
                                <div class="col-3 mt-3 ms-2">
                                    <input class="form-check-input"  type="radio" name="buffer" value="no" checked="checked" />                      
                                    <label class="form-check-label">No</label>
                                </div>
                                <div class="col-3 mt-3">
                                    <input class="form-check-input" type="radio" name="buffer" value="yes" />                                                                
                                    <label class="form-check-label">Yes</label>
                                </div> 
                                <div class="form-group d-flex justify-content-center">
                                    <input type="hidden" name="val" value="slotupdate" />
                                    <button type="submit" class="btn btn-primary col-5 col-sm-3 mt-4">Update Slot</button>                    
                                    <button type="button" class="btn btn-dark col-5 col-sm-3 mt-4 ms-2" data-bs-dismiss="modal">Cancel</button>         
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!----------------------///////UPDATE SLOT MODAL//////////-------------------------->

        <!-------------------------------REMOVE SLOT-------------------------------------->
        <div class="modal fade"  id="RemoveSlotModal" aria-hidden="true" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Remove a Slot</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <!-- Update SLOT -->
                        <form name="SlotDelete" action="AdminPanel" method="POST">                       
                            <div class="form-group row align-items-center">
                                <div class="form-group col-4 ms-5 mt-3">  
                                    <h4 class="label"><b>Slot ID :</b></h4>  
                                </div>
                                <div class="form-group ms-2 col-6 mt-3"> 
                                    <input class="form-control" type="text" name="slot_id" value="" />
                                </div>
                                <div class="form-group d-flex justify-content-center">
                                    <input type="hidden" name="val" value="slotdelete" />
                                    <button type="submit" class="btn btn-primary col-5 col-sm-3 mt-4">Delete Slot</button>                  
                                    <button type="button" class="btn btn-dark col-5 col-sm-3 mt-4 ms-2" data-bs-dismiss="modal">Cancel</button>         
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!----------------------///////REMOVE SLOT MODAL//////////-------------------------->

        <!----------------------Search Buffer SLOT MODAL-------------------------->
        <div class="modal fade"  id="SearchBufferModal" aria-hidden="true" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">ADD New SLot</h5>
                        <!--                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>-->
                    </div>
                    <div class="modal-body">
                        <p class="card-text">Slot id will be created automatically</p>
                        <!-- ADD SLOT -->
                        <form name="Buffer" action="AdminPanel" method="POST">
                            <div class="form-group row align-items-center">
                                <div class="form-group col-4 ms-5 mt-3">  
                                    <h4 class="label"><b>Buffer:</b></h4>
                                </div>
                                <div class="col-3 mt-3 ms-2">
                                    <input class="form-check-input" type="radio" name="status" value="green" checked="checked" />
                                    <label class="form-check-label">GREEN</label>
                                </div>
                                <div class="col-3 mt-3">
                                    <input class="form-check-input" type="radio" name="status" value="red" />                                
                                    <label class="form-check-label">RED</label>
                                </div>

                                <div class="form-group d-flex justify-content-center">
                                    <input type="hidden" name="val" value="buffer" /><br>
                                    <button type="submit" class="btn btn-primary col-5 col-sm-3 mt-4">Search</button>                     
                                    <button type="button" class="btn btn-dark col-5 col-sm-3 mt-4 ms-2" data-bs-dismiss="modal">Cancel</button>         
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!----------------------///////Search Buffer SLOT MODAL//////////-------------------------->

    </body>
</html>
