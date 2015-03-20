var project_open = null;

$(".hub-project-summary").click(function() {
  console.log("* click *")
  var hub_project = $(this).parents(".hub-project")
  console.log("Clicked: " + hub_project.attr("id"))
  var my_id = hub_project.attr("id")
  // First, close any open project:
  if (project_open) {
    $("#" + project_open + " .hub-project-detail").hide()
    if (my_id == project_open) {
      project_open = null
      return
    }
  }
  $(".hub-project-detail", hub_project).show()
  project_open = my_id
})

$(function() {
  $(".hub-project-detail").hide()
})
