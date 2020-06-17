/**
 * csc2024-hibernate-assignment
 *
 * Copyright (c) 2015 Newcastle University
 * Email: <h.firth@ncl.ac.uk/>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package uk.ac.ncl.cs.csc2024.route;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;
import uk.ac.ncl.cs.csc2024.busstop.BusStop;
import uk.ac.ncl.cs.csc2024.operator.Operator;
import uk.ac.ncl.cs.csc2024.query.ExampleQuery;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Collection of Queries relating to Route entities
 *
 * Task: fill out method bodies to create "Queries" which satisfy the
 * requirements laid out in the coursework spec. Other than the `insert(...)`
 * method, where you should return the session to which an Entity object has
 * been persisted, you should return an ExampleQuery object.
 *
 * The methods of the ExampleQuery objects should return a Query, a Named
 * Query's identifier and a Criteria Query for each task laid out in the
 * coursework spec. You should return every query type for each task.
 *
 * An example of how this should look is provided in the `selectAll(...)` query.
 *
 * @author hugofirth
 */
public class RouteQueries {

	public static Session insert(final Map<String, String> row, final Session session) {

		Route route = new Route();
		BusStop start = new BusStop();
		BusStop end = new BusStop();
		Set<Operator> operators = new HashSet<Operator>();
		Operator op1 = new Operator();
		Operator op2 = new Operator();
		route.setRouteNumber(row.get("number"));
		route.setFrequency(Integer.parseInt(row.get("frequency")));
		start.setID(Integer.parseInt(row.get("start")));
		route.setStart(start);
		end.setID(Integer.parseInt(row.get("destination")));
		route.setEnd(end);
		String operator = row.get("operators");
		String delims = "[|]";
		String[] operatorsname = operator.split(delims);
		op1.setName(operatorsname[0]);
		operators.add(op1);
		if (operatorsname[1] != null) {
			op2.setName(operatorsname[1]);
			operators.add(op2);
		}
		route.setOperators(operators);
		session.save(route);
		return session;
	}

	public static ExampleQuery selectAll() {
		return new ExampleQuery() {
			@Override
			public Query getQuery(Session session) {
				return session.createQuery("select r from Route r order by r.number asc");
			}

			@Override
			public String getNamedQueryName() {
				return Route.SELECT_ALL;

			}

			@Override
			public Criteria getCriteria(Session session) {
				Criteria criteria = session.createCriteria(Route.class, "r");
				criteria.addOrder(Order.asc("r.number"));
				return criteria;
			}
		};
	}

	public static ExampleQuery selectAllForRailwayStation() {
		return new ExampleQuery() {
			@Override
			public Query getQuery(Session session) {
				return session.createQuery(
						"select r from Route r, BusStop b where b.description= Railway Station and b.Start or b.End = r.routeNumber");
			}

			@Override
			public String getNamedQueryName() {
				return Route.SELECT_ALL_FOR_RAILWAY_STATION;

			}

			@Override
			public Criteria getCriteria(Session session) {
				Criteria cr = session.createCriteria(Route.class, "r");
				Criteria bcrs = cr.createCriteria("r.Start", "s");
				Criteria bcre = cr.createCriteria("r.End", "e");
				bcrs.add(Restrictions.eq("s.description", "Railway Station"));
				bcre.add(Restrictions.eq("e.description", "Railway Station"));
				return cr;
			}
		};
	}

	public static ExampleQuery cumulativeFrequencyByOkTravel() {
		return new ExampleQuery() {
			@Override
			public Query getQuery(Session session) {
				return session.createQuery(
						"select sum(frequency) from Route r, Operator o where o.name= OK Travel and o.routes= r.operators");
			}

			@Override
			public String getNamedQueryName() {
				return Route.CUMULATIVE_FREQ_BY_OK_TRAVEL;

			}

			@Override
			public Criteria getCriteria(Session session) {
				Criteria cr = session.createCriteria(Route.class, "r");
				Criteria ocr = cr.createCriteria("r.operators", "o");
				ocr.add(Restrictions.eq("o.name", "OK Travel"));
				cr.setProjection(Projections.sum("r.frequency"));

				return cr;
			}
		};
	}

}
