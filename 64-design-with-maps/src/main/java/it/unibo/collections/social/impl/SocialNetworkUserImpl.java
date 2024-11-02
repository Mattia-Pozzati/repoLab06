/**
 * 
 */
package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
//import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     *
     * [FIELDS]
     *
     * Define any necessary field
     *
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:  think of what type of keys and values would best suit the requirements
     */

    private Map<String, Set<U>> followedGroups = new HashMap<String, Set<U>>();

    /*
     * [CONSTRUCTORS]
     *
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     *
     * - firstName
     * - lastName
     * - username
     * - age and every other necessary field
     */
    /**
     * Builds a user participating in a social network.
     *
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
    }

    /*
     * 2) Define a further constructor where the age defaults to -1
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        super(name, surname, user, -1);
    }

    /*
     * [METHODS]
     *
     * Implements the methods below
     */
    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        Set<U> circleFriends = this.followedGroups.get(circle);
        if (circleFriends == null) {
            circleFriends = new HashSet<>();
            this.followedGroups.put(circle, circleFriends);
        }
        return circleFriends.add(user);
    }

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        final Collection<U> usersInCircle = this.followedGroups.get(groupName);
        if (usersInCircle != null) {
            return new ArrayList<>(usersInCircle);
        }
        /*
         * Return a very fast, unmodifiable, pre-cached empty list.
         */
        return Collections.emptyList();
        
    }

    @Override
    public List<U> getFollowedUsers() {
        Set<U> followedusersList = new HashSet<U>();
        for (Entry<String, Set<U>> e : followedGroups.entrySet()) {
            followedusersList.addAll(e.getValue());
        }
        return new ArrayList<>(followedusersList);
    }
}
