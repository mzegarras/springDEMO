 <!DOCTYPE html>
<html> 
<head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8"/> 
  <title>Google Maps Campus</title> 
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCSXfxv7RTxNwv7iwlL-ogxh-t9WdB0DPE&sensor=false"></script>
</head> 
<body> 
  <div id="map" style="width: 550px; height: 400px"></div> 

  <div>Start: 
    <select id="start">
      <option>Building 1</option>
      <option>Building 2</option>
      <option>Building 3</option>
    </select>
  </div>

  <div>End: 
    <select id="end">
      <option>Building 1</option>
      <option>Building 2</option>
      <option>Building 3</option>
    </select>
  </div>

  <input type="button" onclick="drawDirections();" value="GO" />

  <script type="text/javascript"> 
    var mapOptions = { 
      mapTypeId: google.maps.MapTypeId.TERRAIN,
      center: new google.maps.LatLng(47.690, -122.310),
      zoom: 12
    };

    var map = new google.maps.Map(document.getElementById("map"), 
                                  mapOptions);

    // Predefine all the paths
    var paths = [];                         

    paths['1_to_2'] = new google.maps.Polyline({
      path: [
          new google.maps.LatLng(47.656, -122.360),
          new google.maps.LatLng(47.656, -122.343),
          new google.maps.LatLng(47.690, -122.310)
      ], strokeColor: '#FF0000'
    });

    paths['1_to_3'] = new google.maps.Polyline({
       path: [
          new google.maps.LatLng(47.656, -122.360),
          new google.maps.LatLng(47.656, -122.343),
          new google.maps.LatLng(47.690, -122.270)
       ], strokeColor: '#FF0000'
    });

    paths['2_to_3'] = new google.maps.Polyline({
       path: [
           new google.maps.LatLng(47.690, -122.310),
           new google.maps.LatLng(47.690, -122.270)
       ], strokeColor: '#FF0000'
    });

    function drawDirections() {
      var start = 1 + document.getElementById('start').selectedIndex;
      var end = 1 + document.getElementById('end').selectedIndex;
      var i;

      if (start === end) {
        alert('Please choose different buildings');
      }
      else {
        // Hide all polylines
        for (i in paths) {
          paths[i].setOptions({ map: null });
        }

        // Show the route
        if (typeof paths['' + start + '_to_' + end] !== 'undefined') {
          paths['' + start + '_to_' + end].setOptions({ map: map });
        }
        else if (typeof paths['' + end + '_to_' + start] !== 'undefined') {
          paths['' + end + '_to_' + start].setOptions({ map: map });
        }
      }
    }
  </script> 
</body> 
</html>