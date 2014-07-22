/*
 * Licensed to Prodevelop SL under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The Prodevelop SL licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * 
 * For more information, contact:
 *
 *   Prodevelop, S.L.
 *   Pza. Don Juan de Villarrasa, 14 - 5
 *   46001 Valencia
 *   Spain
 *
 *   +34 963 510 612
 *   +34 963 510 968
 *   prode@prodevelop.es
 *   http://www.prodevelop.es
 * 
 * @author Alberto Romeu Carrasco http://www.albertoromeu.com
 */

package es.alrocar.jpe.parser.configuration;

import java.io.IOException;
import java.net.URL;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import es.alrocar.jpe.BaseJSONTest;
import es.alrocar.poiproxy.configuration.DescribeService;
import es.alrocar.poiproxy.configuration.DescribeServices;
import es.alrocar.poiproxy.proxy.POIProxy;

public class TestDescribeServices extends BaseJSONTest {

	private String services = "{instagram:"
			+ "{"
			+ "    format: \"json\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"https://api.instagram.com/v1/media/search?distance=__DIST__&lat=__LAT__&lng=__LON__&access_token=37074513.bc3142f.9f43f4cd65db48e2870de22e1c798c01\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"b\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"type\","
			+ "                    	\"elements\" : [\"link\", \"username\", \"profile_picture\", \"url\", \"id\", \"name\"],"
			+ "                    	\"lon\": \"longitude\", "
			+ "                    	\"lat\": \"latitude\""
			+ "                    	},\"search\" : {"
			+ "                    	\"feature\" : \"kind\","
			+ "                    	\"elements\" : [\"title\", \"published\", \"name\", \"profileUrl\", \"thumbnailUrl\"],"
			+ "                    	\"lon\": \"longi\", "
			+ "                    	\"lat\": \"lat\","
			+ "                    	\"combinedLonLat\": \"geocode\","
			+ "                    	\"separator\": \" \""
			+ ""
			+ "                    	}"
			+ "                    }"
			+ "}},{mapquest:"
			+ "{"
			+ "    format: \"json\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://www.mapquestapi.com/geocoding/v1/reverse?key=Fmjtd|luu22h62nl%2Cr0%3Do5-h07n5&lat=__LAT__&lng=__LON__\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"http://www.mapquestapi.com/geocoding/v1/address?key=Fmjtd|luu22h62nl%2Cr0%3Do5-h07n5&inFormat=kvp&outFormat=json&location=__QUERY__\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"latLng\","
			+ "                    	\"elements\" : [\"adminArea5\", \"adminArea5Type\", \"street\", \"postalCode\"],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	},\"search\" : {"
			+ "                    	\"feature\" : \"latLng\","
			+ "                    	\"elements\" : [\"adminArea5\", \"adminArea5Type\", \"street\", \"postalCode\"],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\""
			+ ""
			+ "                    	}"
			+ "                    }"
			+ "}},{testwfs:"
			+ "{"
			+ "    format: \"xml\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://agroasesor.prodevelop.es/geoserver/wfs?TYPENAME=world%3Acities&SERVICE=WFS&VERSION=1.0.0&REQUEST=GetFeature&SRS=EPSG%3A4326\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"b\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"featureMember\","
			+ "                    	\"elements\" : [\"City\", \"Country\"],"
			+ "                    	\"lon\": \"longitude\", "
			+ "                    	\"lat\": \"latitude\""
			+ "                    	},\"search\" : {"
			+ "                    	\"feature\" : \"kind\","
			+ "                    	\"elements\" : [\"title\", \"published\", \"name\", \"profileUrl\", \"thumbnailUrl\"],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	}"
			+ "                    }"
			+ "}},{geonamespois:"
			+ "{"
			+ "    format: \"xml\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://api.geonames.org/findNearbyPOIsOSM?lat=__LAT__&lng=__LON__&username=poiproxy\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"b\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"poi\","
			+ "                    	\"elements\" : [\"typeClass\", \"typeName\", \"name\", \"distance\"],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	},"
			+ "                        \"search\" : {"
			+ "                    	\"feature\" : \"geoname\","
			+ "                    	\"elements\" : [\"name\", \"countryName\", \"distance\", ],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	},"
			+ "                    }"
			+ "}},{simplegeo:"
			+ "{"
			+ "    format: \"json\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://api.simplegeo.com/1.0/places/__LAT__,__LON__.json?token=ypD3EcHsa4XzuPtNKe8ySFEPEqDbwQ3A\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"http://api.simplegeo.com/1.0/places/__LAT__,__LON__.json?token=ypD3EcHsa4XzuPtNKe8ySFEPEqDbwQ3A&q=__QUERY__\", \"params\": []},"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"geometry\","
			+ "                    	\"elements\" : [\"distance\", \"name\", \"city\", \"postcode\", \"category\", \"subcategory\"],"
			+ "                    	\"lon\": \"coordinates\", "
			+ "                    	\"lat\": \"coordinates\""
			+ "                    	},\"search\" : {"
			+ "                    	\"feature\" : \"geometry\","
			+ "                    	\"elements\" : [\"distance\", \"name\", \"city\", \"postcode\", \"category\", \"subcategory\"],"
			+ "                    	\"lon\": \"coordinates\", "
			+ "                    	\"lat\": \"coordinates\""
			+ "                    	}"
			+ "                    }"
			+ "}},{geonames:"
			+ "{"
			+ "    format: \"xml\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://api.geonames.org/findNearbyPlaceName?lat=__LAT__&lng=__LON__&username=poiproxy\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"b\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"geoname\","
			+ "                    	\"elements\" : [\"name\", \"countryName\", \"distance\", ],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	},"
			+ "                        \"search\" : {"
			+ "                    	\"feature\" : \"geoname\","
			+ "                    	\"elements\" : [\"name\", \"countryName\", \"distance\", ],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	},"
			+ "                    }"
			+ "}},{ovi:"
			+ "{"
			+ "    format: \"json\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://where.desktop.mos.svc.ovi.com/json?to=20&la=es-ES&lat=__LAT__&lon=__LON__&ds=1200&vi=places\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"http://where.desktop.mos.svc.ovi.com/json?q=__QUERY__&to=20&la=es-ES&lat=__LAT__&lon=__LON__&ds=1200&vi=places\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"id\","
			+ "                    	\"elements\" : [\"addrStreetName\", \"addrHouseNumber\", \"addrDistrictName\", \"addrCountryName\", \"geoDistance\", \"addrCityName\", \"title\", \"phoneNumber\"],"
			+ "                    	\"lon\": \"geolatitude\", "
			+ "                    	\"lat\": \"geoLongitude\""
			+ "                    	"
			+ "                    	},\"search\" : {"
			+ "						\"feature\" : \"id\","
			+ "                    	\"elements\" : [\"addrStreetName\", \"addrHouseNumber\", \"addrDistrictName\", \"addrCountryName\", \"geoDistance\", \"addrCityName\", \"title\", \"phoneNumber\"],"
			+ "                    	\"lon\": \"geolatitude\", "
			+ "                    	\"lat\": \"geoLongitude\""
			+ "                    	"
			+ "                    	}"
			+ "                    }"
			+ "}},{twitter:"
			+ "{"
			+ "    format: \"json\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://search.twitter.com/search.json?result_type=recent&callback=?&geocode=__LAT__,__LON__,__DISTKM__km\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"b\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"created_at\","
			+ "                    	\"elements\" : [\"from_user\", \"from_user_id\", \"location\", \"text\", \"full_name\", \"source\"],"
			+ "                    	\"lon\": \"coordinates\", "
			+ "                    	\"lat\": \"coordinates\"                    	"
			+ "                    	},\"search\" : {"
			+ "                    	\"feature\" : \"created_at\","
			+ "                    	\"elements\" : [\"from_user\", \"from_user_id\", \"location\", \"text\", \"full_name\", \"source\"],"
			+ "                    	\"lon\": \"coordinates\", "
			+ "                    	\"lat\": \"coordinates\"                    	"
			+ "                    	}"
			+ "                    }"
			+ "}},{buzz:"
			+ "{"
			+ "    format: \"json\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"https://www.googleapis.com/buzz/v1/activities/search?key=AIzaSyDM7V5F3X0g4_aH6YSwsR4Hbd_uBuQ3QeA&lat=__LAT__&lon=__LON__&radius=__DIST__&alt=json\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"b\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"kind\","
			+ "                    	\"elements\" : [\"title\", \"published\", \"name\", \"profileUrl\", \"thumbnailUrl\"],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\","
			+ "                    	\"combinedLonLat\": \"geocode\","
			+ "                    	\"separator\": \" \""
			+ ""
			+ "                    	},\"search\" : {"
			+ "                    	\"feature\" : \"kind\","
			+ "                    	\"elements\" : [\"title\", \"published\", \"name\", \"profileUrl\", \"thumbnailUrl\"],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\","
			+ "                    	\"combinedLonLat\": \"geocode\","
			+ "                    	\"separator\": \" \""
			+ ""
			+ "                    	}"
			+ "                    }"
			+ "}},{youtube:"
			+ "{"
			+ "    format: \"json\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://gdata.youtube.com/feeds/api/videos?location=__LON__,__LAT__&location-radius=__DIST__km\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"b\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"entry\","
			+ "                    	\"elements\" : [\"id\", \"published\", \"title\", \"link\"],"
			+ "                    	\"lon\": \"pos\", "
			+ "                    	\"lat\": \"pos\""
			+ "                    	},\"search\" : {"
			+ "                    	\"feature\" : \"title\","
			+ "                    	\"elements\" : [\"title\", \"published\", \"name\", \"profileUrl\", \"thumbnailUrl\"],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\","
			+ "                    	\"combinedLonLat\": \"geocode\","
			+ "                    	\"separator\": \" \""
			+ ""
			+ "                    	}"
			+ "                    }"
			+ "}},{foursquare:"
			+ "{"
			+ "    format: \"json\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"https://api.foursquare.com/v2/venues/search?ll=__LAT__,__LON__&client_id=S5MN2YCYHT5EQS31KC1I10L4ELT43IGXO0FWE0IDTMSO5J2F&client_secret=QUIBVAC2Q0IIYVKVLJEMMABXEUEMTR3KJC3Z12UG5MCKFTSR\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"b\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"name\","
			+ "                    	\"elements\" : [\"name\", \"address\", \"city\", \"state\"],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	},\"search\" : {"
			+ "                    	\"feature\" : \"name\","
			+ "                    	\"elements\" : [\"name\", \"address\", \"city\", \"state\"],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	}"
			+ "                    }"
			+ "}},{nominatim:"
			+ "{"
			+ "    format: \"json\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    browse: {\"url\": \"http://nominatim.openstreetmap.org/search?q=__QUERY__&format=json&polygon=1&addressdetails=1\", \"params\": []},"
			+ "                    search: {\"url\": \"http://nominatim.openstreetmap.org/reverse?format=json&lat=__LAT__&lon=__LON__&addressdetails=1\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { browse : {"
			+ "                    	\"feature\" : \"place_id\","
			+ "                    	\"elements\" : [\"display_name\", \"city\", \"state\", \"postcode\", \"country\"],"
			+ "                    	\"lon\": \"lon\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	},"
			+ "                        search : {"
			+ "                    	\"feature\" : \"place_id\","
			+ "                    	\"elements\" : [\"display_name\", \"city\", \"state\", \"postcode\", \"country\"],"
			+ "                    	\"lon\": \"lon\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	}"
			+ "                    }"
			+ "}},{mapquestsearch:"
			+ "{"
			+ "    format: \"json\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://www.mapquestapi.com/search/v1/rectangle?key=Fmjtd|luu22h62nl%2Cr0%3Do5-h07n5&boundingBox=__MAXY__,__MINX__,__MINY__,__MAXX__\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"http://www.mapquestapi.com/geocoding/v1/address?key=Fmjtd|luu22h62nl%2Cr0%3Do5-h07n5&inFormat=kvp&outFormat=json&location=__QUERY__\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"gefId\","
			+ "                    	\"elements\" : [\"distance\", \"poiImageUrl\", \"name\", \"N\", \"Phone\", \"City\", \"Country\", \"Address\"],"
			+ "                    	\"lon\": \"Lng\", "
			+ "                    	\"lat\": \"Lat\""
			+ "                    	},\"search\" : {"
			+ "                    	\"feature\" : \"latLng\","
			+ "                    	\"elements\" : [\"adminArea5\", \"adminArea5Type\", \"street\", \"postalCode\"],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\""
			+ ""
			+ "                    	}"
			+ "                    }"
			+ "}},{wikilocation:"
			+ "{"
			+ "    format: \"json\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://api.wikilocation.org/articles?lat=__LAT__&lng=__LON__&radius=__DIST__\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"b\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"id\","
			+ "                    	\"elements\" : [\"title\", \"url\", \"distance\"],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	},\"search\" : {"
			+ "                    	\"feature\" : \"kind\","
			+ "                    	\"elements\" : [\"title\", \"published\", \"name\", \"profileUrl\", \"thumbnailUrl\"],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\","
			+ "                    	\"combinedLonLat\": \"geocode\","
			+ "                    	\"separator\": \" \""
			+ ""
			+ "                    	}"
			+ "                    }"
			+ "}},{cloudmade:"
			+ "{"
			+ "    format: \"json\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://geocoding.cloudmade.com/8ee2a50541944fb9bcedded5165f09d9/geocoding/v2/find.geojs?around=__LAT__,__LON__&distance=closest&results=20\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"http://geocoding.cloudmade.com/8ee2a50541944fb9bcedded5165f09d9/geocoding/v2/find.geojs?query=__QUERY__\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"id\","
			+ "                    	\"elements\" : [\"addr:city\", \"addr:street\", \"addr:country\", \"phone\", \"synthesized_name\"],"
			+ "                    	\"lon\": \"coordinates\", "
			+ "                    	\"lat\": \"coordinates\""
			+ ""
			+ "                    	},\"search\" : {"
			+ "                    	\"feature\" : \"id\","
			+ "                    	\"elements\" : [\"addr:city\", \"addr:street\", \"addr:country\", \"phone\", \"synthesized_name\"],"
			+ "                    	\"lon\": \"coordinates\", "
			+ "                    	\"lat\": \"coordinates\""
			+ "                    	}"
			+ "                    }"
			+ "}},{panoramio:"
			+ "{"
			+ "    format: \"json\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://www.panoramio.com/map/get_panoramas.php?set=public&from=0&to=50&minx=__MINX__&miny=__MINY__&maxx=__MAXX__&maxy=__MAXY__&size=square&mapfilter=true\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"b\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"upload_date\","
			+ "                    	\"elements\" : [\"photo_url\", \"photo_title\", \"photo_file_url\"],"
			+ "                    	\"lon\": \"longitude\", "
			+ "                    	\"lat\": \"latitude\""
			+ "                    	},"
			+ "                        \"search\" : {"
			+ "                    	\"feature\" : \"upload_date\","
			+ "                    	\"elements\" : [\"photo_url\", \"photo_title\", \"photo_file_url\"],"
			+ "                    	\"lon\": \"longitude\", "
			+ "                    	\"lat\": \"latitude\""
			+ "                    	}"
			+ "                    }"
			+ "}},{flickr:"
			+ "{"
			+ "    format: \"json\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    browse: {\"url\": \"http://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=&bbox=__MINX__%2C__MINY__%2C__MAXX__%2C__MAXY__&media=&has_geo=1&extras=geo%2C+media%2C+path_alias%2C+url_sq%2C+url_t%2C+url_s%2C+url_m%2C+url_z%2C+url_l%2C+url_o&format=json&nojsoncallback=1&per_page=20&accuracy=3&sort=interestingness-desc&min_upload_date=1157305292.956\", \"params\": []},"
			+ "                    search: {\"url\": \"http://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=&bbox=__MINX__%2C__MINY__%2C__MAXX__%2C__MAXY__&media=&has_geo=1&extras=geo%2C+media%2C+path_alias%2C+url_sq%2C+url_t%2C+url_s%2C+url_m%2C+url_z%2C+url_l%2C+url_o&format=json&nojsoncallback=1&text=__QUERY__&per_page=20&accuracy=3&sort=interestingness-desc&min_upload_date=1157305292.956\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { browse : {"
			+ "                    	\"feature\" : \"id\","
			+ "                    	\"elements\" : [\"title\", \"url_t\", \"url_o\", \"url_m\", \"url_z\", \"url_s\", \"url_l\"],"
			+ "                    	\"lon\": \"longitude\", "
			+ "                    	\"lat\": \"latitude\""
			+ "                    	},"
			+ "                        search : {"
			+ "                    	\"feature\" : \"id\","
			+ "                    	\"elements\" : [\"title\", \"url_t\", \"url_o\", \"url_m\", \"url_z\", \"url_s\", \"url_l\"],"
			+ "                    	\"lon\": \"longitude\", "
			+ "                    	\"lat\": \"latitude\""
			+ "                    	}"
			+ "                    }"
			+ "}},{lastfm:"
			+ "{"
			+ "    format: \"xml\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://ws.audioscrobbler.com/2.0/?method=geo.getevents&lat=__LAT__&long=__LON__&distance=__DIST__&api_key=b25b959554ed76058ac220b7b2e0a026\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"b\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"event\","
			+ "                    	\"elements\" : [\"title\", \"artist\", \"name\", \"city\", \"country\", \"street\", \"postalcode\", \"url\", \"startDate\", \"startTime\", \"phonenumber\", \"website\", \"url\", \"description\"],"
			+ "                    	\"lon\": \"long\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	},"
			+ "                    \"search\" : {"
			+ "                    	\"feature\" : \"event\","
			+ "                    	\"elements\" : [\"title\", \"artist\", \"name\", \"city\", \"country\", \"street\", \"postalcode\", \"url\", \"startDate\", \"startTime\", \"phonenumber\", \"website\", \"url\", \"description\"],"
			+ "                    	\"lon\": \"long\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	}"
			+ "                    }"
			+ "	}"
			+ "},{geonamestopo:"
			+ "{"
			+ "    format: \"xml\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://api.geonames.org/findNearby?lat=__LAT__&lng=__LON__&username=poiproxy\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"b\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"geoname\","
			+ "                    	\"elements\" : [\"name\", \"countryName\", \"distance\", \"toponymName\" ],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	},"
			+ "                        \"search\" : {"
			+ "                    	\"feature\" : \"geoname\","
			+ "                    	\"elements\" : [\"name\", \"countryName\", \"distance\", ],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	},"
			+ "                    }"
			+ "}},{geonameswiki:"
			+ "{"
			+ "    format: \"xml\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"http://api.geonames.org/wikipediaSearch?q=__QUERY__&maxRows=10&username=poiproxy\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"geoname\","
			+ "                    	\"elements\" : [\"name\", \"countryName\", \"distance\", \"toponymName\" ],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	},"
			+ "                        \"search\" : {"
			+ "                    	\"feature\" : \"entry\","
			+ "                    	\"elements\" : [\"title\", \"summary\", \"wikipediaUrl\", \"thumbnailImg\"],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	},"
			+ "                    }"
			+ "}},{minube:"
			+ "{"
			+ "    format: \"json\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://api.minube.com/places/coordinates.json%3Fapi_key%%26latitude%3D__LAT__%26longitude%3D__LON__%26distance%3D__DIST__%26limit%3D20%26order%3Ddate\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"b\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"id\","
			+ "                    	\"elements\" : [\"name\", \"distance\", \"address\", \"website\", \"url\", \"zip_code\", \"telephone\"],"
			+ "                    	\"lon\": \"longitude\", "
			+ "                    	\"lat\": \"latitude\""
			+ "                    	}, \"search\" : {"
			+ "                    	\"feature\" : \"id\","
			+ "                    	\"elements\" : [\"name\", \"distance\", \"address\", \"website\", \"url\", \"zip_code\", \"telephone\"],"
			+ "                    	\"lon\": \"longitude\", "
			+ "                    	\"lat\": \"latitude\""
			+ "                    	}"
			+ "                    }"
			+ "}},{wikipedia:"
			+ "{"
			+ "    format: \"json\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://api.wikilocation.org/articles?lat=__LAT__&lng=__LON__&limit=20\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"b\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"id\","
			+ "                    	\"elements\" : [\"title\", \"url\", \"distance\"],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	}, \"search\" : {"
			+ "                    	\"feature\" : \"id\","
			+ "                    	\"elements\" : [\"title\", \"url\", \"distance\"],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	}"
			+ "                    }"
			+ "}},{geonamesstreets:"
			+ "{"
			+ "    format: \"xml\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://api.geonames.org/findNearbyStreetsOSM?lat=__LAT__&lng=__LON__&username=poiproxy\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"b\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"streetSegment\","
			+ "                    	\"elements\" : [\"name\", \"distance\"],"
			+ "                    	\"lon\": \"\", "
			+ "                    	\"lat\": \"\""
			+ "                    	},"
			+ "                        \"search\" : {"
			+ "                    	\"feature\" : \"geoname\","
			+ "                    	\"elements\" : [\"name\", \"countryName\", \"distance\", ],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	},"
			+ "                    }"
			+ "}},{mapquestnominatim:"
			+ "{"
			+ "    format: \"json\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://open.mapquestapi.com/nominatim/v1/reverse?format=json&lat=__LAT__&lon=__LON__\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"http://open.mapquestapi.com/nominatim/v1/search?format=json&q=__QUERY__&addressdetails=1&viewbox=__MINX__%2C__MAXY__%2C__MAXX__%2C__MINY__\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"place_id\","
			+ "                    	\"elements\" : [\"osm_id\", \"display_name\", \"city\", \"country\", \"state\", \"postcode\"],"
			+ "                    	\"lon\": \"lon\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	},\"search\" : {"
			+ "                    	\"feature\" : \"place_id\","
			+ "                    	\"elements\" : [\"osm_id\", \"display_name\", \"city\", \"country\", \"state\", \"postcode\"],"
			+ "                    	\"lon\": \"lon\", "
			+ "                    	\"lat\": \"lat\""
			+ "                    	}"
			+ "                    }"
			+ "}},{gowalla:"
			+ "{"
			+ "    format: \"json\","
			+ "    apiKey : \"\","
			+ "    requestTypes : {"
			+ "                    \"browse\": {\"url\": \"http://api.gowalla.com/spots?lat=__LAT__&lng=__LON__&radius=__DIST__\", \"params\": []},"
			+ "                    \"search\": {\"url\": \"b\", \"params\": []}"
			+ "                    },"
			+ "    featureTypes : { \"browse\" : {"
			+ "                    	\"feature\" : \"checkins_count\","
			+ "                    	\"elements\" : [\"locality\", \"activity_url\", \"image_url\", \"name\", \"url\", \"items_url\", \"description\", \"_image_url_50\"],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\","
			+ "                    	\"combinedLonLat\": \"geocode\","
			+ "                    	\"separator\": \" \""
			+ ""
			+ "                    	},\"search\" : {"
			+ "                    	\"feature\" : \"title\","
			+ "                    	\"elements\" : [\"title\", \"published\", \"name\", \"profileUrl\", \"thumbnailUrl\"],"
			+ "                    	\"lon\": \"lng\", "
			+ "                    	\"lat\": \"lat\","
			+ "                    	\"combinedLonLat\": \"geocode\","
			+ "                    	\"separator\": \" \"" + ""
			+ "                    	}" + "                    }" + "}}";

	public void testServices() throws JsonGenerationException,
			JsonMappingException, IOException {
		URL uReport = POIProxy.class.getClassLoader().getResource(
				this.getResource());
		System.out.println(uReport.getPath());

		String json = this.getJSON(uReport.getPath());

		assertTrue(json.length() > 0);

		DescribeServiceParser parser = new DescribeServiceParser();
		DescribeService service = parser.parse(json);

		DescribeServices services = new DescribeServices();
		services.put("buzz", service);

		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(services));

		// DescribeServices ss = services.fromJSON(this.services);
		// int i = 0;

	}

	@Override
	public String getResource() {
		return "buzz.json";
	}

}