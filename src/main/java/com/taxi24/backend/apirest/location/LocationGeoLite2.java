package com.taxi24.backend.apirest.location;


import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.Location;

public class LocationGeoLite2 {
	
	public static void getLocation() {
		
		String dbLocation = "GeoLite2-City.mmdb";
		File database = new File(dbLocation);
		try {
			//InetAddress ip = InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
			DatabaseReader reader = new DatabaseReader.Builder(database).build();
			InetAddress ipAddress = InetAddress.getByName("128.101.101.101");
			CityResponse response = reader.city(ipAddress);
			Location loc = response.getLocation();

	        Double lat = loc.getLatitude();
	        Double lng = loc.getLongitude();
	        Integer acc = loc.getAccuracyRadius();

	        System.out.println("lat=" + lat + "\nlng=" + lng + "\nacc=" + acc);
		} catch (IOException e) {
			e.printStackTrace();
		}catch (GeoIp2Exception e) {
	        e.printStackTrace();
	    }
		
	}
	
	public static double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {
        //double radioTierra = 3958.75;//en millas
        double radioTierra = 6371;//en kilómetros
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distancia = radioTierra * va2;
   
        return distancia;
    }
	
}
